package com.mailsender.domain.services.implementation;

import com.mailsender.domain.model.mail.MailMessageModel;
import com.mailsender.domain.model.mail.MailMessageType;
import com.mailsender.domain.model.mail.Message;
import com.mailsender.domain.model.user.UserModel;
import com.mailsender.domain.services.interfaces.IMailService;
import com.mailsender.domain.services.requests.SendMailServiceRequest;
import com.mailsender.infrastructure.mail.IMailSender;
import com.mailsender.infrastructure.repository.MailMessageRepository;
import com.mailsender.infrastructure.repository.UserRepository;
import com.mailsender.web.results.GetMailLogResult;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailService implements IMailService {
    private UserRepository userRepository;
    private UserService userService;
    private MailMessageRepository mailMessageRepository;
    private IMailSender mailSender;

    public MailService(UserRepository userRepository, UserService userService, MailMessageRepository mailMessageRepository, IMailSender mailSender) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.mailMessageRepository = mailMessageRepository;
        this.mailSender = mailSender;
    }

    @Override
    public void sendMessage(SendMailServiceRequest request) {
        UserModel user = getUserById(request.getUserId());

        Message message = new Message(request.getSubject(), user.getEmail(), request.getText());
        mailSender.send(message);

        MailMessageModel messageLog = new MailMessageModel(user.getId(), MailMessageType.REST);
        mailMessageRepository.save(messageLog);
    }

    @Override
    public List<GetMailLogResult> getMessagesLog(Integer page) {
        List<UserModel> users = userService.getUsers(page);

        List<GetMailLogResult> result = new ArrayList<>();
        for (UserModel user : users){
            List<MailMessageModel> messageLogs = mailMessageRepository.findByUserIdOrderByCreatedOnAsc(user.getId());

            result.add(new GetMailLogResult(user, messageLogs));
        }
        return result;
    }


    private UserModel getUserById(Integer id){
        UserModel user = userRepository.findById(id).get();
        Assert.notNull(user, "User with id" + id + "not exist");
        return user;
    }
}
