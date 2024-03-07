package com.mailsender.domain.model.corn;

import com.mailsender.domain.services.interfaces.ICornService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitCorns {
    private static final Logger log = LoggerFactory.getLogger(InitCorns.class);
    private ICornService cornService;

    public InitCorns(ICornService cornService) {
        this.cornService = cornService;
    }

    @PostConstruct
    public void init() {
        cornService.executeCornJobs();
        log.info("Corn jobs loaded from database");
    }
}