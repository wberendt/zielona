package com.zielona.tesla.api;

import com.zielona.tesla.model.atms.ATM;
import com.zielona.tesla.model.atms.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Validated
public interface AtmsApi {

    /**
     * POST /atms/calculateOrder
     * Calculates ATMs order for service team
     *
     * @param task  (required)
     * @return Successful operation (status code 200)
     */

    @PostMapping(value = "/atms/calculateOrder",
            produces = "application/json",
            consumes = "application/json")
    ResponseEntity<List<ATM>> calculate(@RequestBody List<Task> task);
}
