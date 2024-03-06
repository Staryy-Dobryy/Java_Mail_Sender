package com.mailsender.infrastructure.repository;

import com.mailsender.domain.model.corn.CornModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CornRepository extends JpaRepository<CornModel, Integer> {
}
