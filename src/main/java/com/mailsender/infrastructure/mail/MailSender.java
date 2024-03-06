package com.mailsender.infrastructure.mail;

import com.mailsender.domain.model.mail.Message;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class MailSender implements IMailSender{
    private JavaMailSender mailSender;

    public MailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    @Override
    public void send(Message message) {
        Assert.notNull(message, "Parameter `message` must not be null");

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("cloud.mailsender.test@gmail.com");
        mailMessage.setSubject(message.getSubject());
        mailMessage.setText(message.getText());
        mailMessage.setTo(message.getTo());

        mailSender.send(mailMessage);

    }
}