package com.mailsender.infrastructure.mail;

import com.mailsender.domain.model.mail.Message;

public interface IMailSender {
    void send(Message message);
}
