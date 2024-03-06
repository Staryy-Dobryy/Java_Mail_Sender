package com.mailsender.domain.services.interfaces;

import com.mailsender.domain.services.requests.SendMailServiceRequest;
import com.mailsender.web.results.GetMailLogResult;

import java.util.List;

public interface IMailService {
    void sendMessage(SendMailServiceRequest request);
    List<GetMailLogResult> getMessagesLog(Integer page);
}
