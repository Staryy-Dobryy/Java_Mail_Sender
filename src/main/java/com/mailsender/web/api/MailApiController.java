package com.mailsender.web.api;

import com.mailsender.domain.model.mail.Message;
import com.mailsender.domain.services.interfaces.IMailService;
import com.mailsender.domain.services.requests.SendMailServiceRequest;
import com.mailsender.infrastructure.mail.IMailSender;
import com.mailsender.web.payload.SendMailPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/mail")
public class MailApiController {
    private IMailService mailService;

    public MailApiController(IMailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping
    @RequestMapping(value = "/logs/{page}")
    public ResponseEntity getLogs(@PathVariable Integer page){
        return ResponseEntity.ok(mailService.getMessagesLog(page));
    }

    @PostMapping
    public ResponseEntity postMail(@RequestBody SendMailPayload payload){
        try {
            SendMailServiceRequest request = payload.toRequest();
            mailService.sendMessage(request);

            return ResponseEntity.ok().build();
        }
        catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
