package com.zielona.tesla.api;

import com.zielona.tesla.model.atms.ATM;
import com.zielona.tesla.model.atms.Task;
import com.zielona.tesla.service.AtmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AtmsApiController implements AtmsApi {

    private final AtmsService atmsService;

    @Autowired
    public AtmsApiController(AtmsService atmsService) {
        this.atmsService = atmsService;
    }

    @Override
    public ResponseEntity<List<ATM>> calculate(List<Task> tasks) {
        return ResponseEntity.ok().body(atmsService.calculate(tasks));
    }
}
