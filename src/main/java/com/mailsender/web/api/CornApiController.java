package com.mailsender.web.api;

import com.mailsender.domain.services.interfaces.ICornService;
import com.mailsender.domain.services.requests.CreateCornServiceRequest;
import com.mailsender.domain.services.requests.UpdateCornServiceRequest;
import com.mailsender.web.payload.CreateCornPayload;
import com.mailsender.web.payload.UpdateCornPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/corn")
public class CornApiController {

    private ICornService cornService;

    public CornApiController(ICornService cornService) {
        this.cornService = cornService;
    }

    @GetMapping
    public ResponseEntity getCorns(){
        return ResponseEntity.ok(cornService.getAllCorns());
    }

    @PostMapping
    public ResponseEntity createCornJob(@RequestBody CreateCornPayload payload) {
        CreateCornServiceRequest request = payload.toRequest();

        cornService.createCorn(request);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCornJob(@PathVariable Integer id, @RequestBody UpdateCornPayload payload) {
        UpdateCornServiceRequest request = payload.toRequest();

        cornService.updateCorn(id, request);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCornJob(@PathVariable Integer id) {
        cornService.deleteCorn(id);

        return ResponseEntity.ok().build();
    }

    @Scheduled(fixedRate = 60000) // Проверка каждую минуту
    public void executeCornJobs() {
        cornService.executeCornJobs();
    }
}
