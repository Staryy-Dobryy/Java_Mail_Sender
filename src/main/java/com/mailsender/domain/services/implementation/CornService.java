package com.mailsender.domain.services.implementation;

import com.mailsender.domain.model.corn.CornModel;
import com.mailsender.domain.model.mail.MailMessageModel;
import com.mailsender.domain.model.mail.MailMessageType;
import com.mailsender.domain.model.mail.Message;
import com.mailsender.domain.model.user.UserModel;
import com.mailsender.domain.services.interfaces.ICornService;
import com.mailsender.domain.services.requests.CreateCornServiceRequest;
import com.mailsender.domain.services.requests.UpdateCornServiceRequest;
import com.mailsender.infrastructure.mail.IMailSender;
import com.mailsender.infrastructure.repository.CornRepository;
import com.mailsender.infrastructure.repository.MailMessageRepository;
import com.mailsender.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import java.util.List;

@Service
public class CornService implements ICornService {
    private Map<Integer, ScheduledFuture<?>> jobsMap = new HashMap<>();
    private TaskScheduler taskScheduler;
    private CornRepository cornRepository;
    private UserRepository userRepository;
    private IMailSender mailSender;
    private MailMessageRepository mailMessageRepository;

    public CornService(TaskScheduler taskScheduler, CornRepository cornRepository, UserRepository userRepository, IMailSender mailSender, MailMessageRepository mailMessageRepository) {
        this.taskScheduler = taskScheduler;
        this.cornRepository = cornRepository;
        this.userRepository = userRepository;
        this.mailSender = mailSender;
        this.mailMessageRepository = mailMessageRepository;
    }

    @Override
    public List<CornModel> getAllCorns() {
        return cornRepository.findAll();
    }

    @Override
    public void createCorn(CreateCornServiceRequest request) {
        UserModel user = userRepository.findById(request.getUserId()).get();
        Assert.notNull(user, "User with id" + request.getUserId() + "not exist");

        CornModel newCorn = new CornModel(request.getUserId(), request.getExpression(), request.getSubject(), request.getText());

        cornRepository.save(newCorn);
        scheduleCorn(newCorn);
    }

    @Override
    public void updateCorn(Integer id, UpdateCornServiceRequest request) {
        CornModel existingModel = cornRepository.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));
        existingModel.setExpression(request.getExpression());
        cornRepository.save(existingModel);

        ScheduledFuture<?> future = jobsMap.get(id);
        if (future != null) {
            future.cancel(true);
        }
        scheduleCorn(existingModel);
    }

    @Override
    public void deleteCorn(Integer id) {
        cornRepository.deleteById(id);
        ScheduledFuture<?> future = jobsMap.get(id);
        if (future != null) {
            future.cancel(true);
        }
    }

    @Override
    public void executeCornJobs() {
        List<CornModel> cornJobs = cornRepository.findAll();

        for (CornModel corn : cornJobs){
            if(jobsMap.get(corn.getId()) == null){
                scheduleCorn(corn);
            }
        }
    }


    private void scheduleCorn(CornModel corn) {
        ScheduledFuture<?> future = taskScheduler.schedule(
                () -> someMethod(corn),
                new CronTrigger(corn.getExpression())
        );
        jobsMap.put(corn.getId(), future);
    }

    private void someMethod(CornModel corn) {
        UserModel user = userRepository.findById(corn.getUserId()).get();

        Message message = new Message(corn.getSubject(), user.getEmail(), corn.getText());
        mailSender.send(message);

        MailMessageModel messageLog = new MailMessageModel(user.getId(), MailMessageType.CORN);
        mailMessageRepository.save(messageLog);
    }
}
