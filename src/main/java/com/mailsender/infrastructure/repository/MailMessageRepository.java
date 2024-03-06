package com.mailsender.infrastructure.repository;

import com.mailsender.domain.model.mail.MailMessageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MailMessageRepository extends JpaRepository<MailMessageModel, Integer> {
    List<MailMessageModel> findByUserIdOrderByCreatedOnAsc(Integer userId);
}
