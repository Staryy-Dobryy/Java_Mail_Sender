package com.mailsender.domain.services.interfaces;

import com.mailsender.domain.model.corn.CornModel;
import com.mailsender.domain.services.requests.CreateCornServiceRequest;
import com.mailsender.domain.services.requests.UpdateCornServiceRequest;

import java.util.List;

public interface ICornService {
    List<CornModel> getAllCorns();
    void createCorn(CreateCornServiceRequest request);
    void updateCorn(Integer id, UpdateCornServiceRequest request);
    void deleteCorn(Integer id);
    void executeCornJobs();
}
