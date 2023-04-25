package com.zielona.tesla.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zielona.tesla.model.atms.ATM;
import com.zielona.tesla.model.atms.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

class AtmsServiceTest {

    private AtmsService atmsService = new AtmsServiceImpl();
    private ObjectMapper mapper = new ObjectMapper();

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void calculate(int testNumber) throws IOException {
        List<Task> tasks = getRequest("/atmservice/example_" + testNumber + "_request.json");
        List<ATM> atms = getExpectedResponse("/atmservice/example_"+ testNumber + "_response.json");

        var result = atmsService.calculate(tasks);
        Assertions.assertArrayEquals(atms.toArray(), result.toArray());
    }

    private List<ATM> getExpectedResponse(String jsonFile) throws IOException {
        InputStream isResponse = ATM.class.getResourceAsStream(jsonFile);
        List<ATM> atms = Arrays.asList(mapper.readValue(isResponse, ATM[].class));
        isResponse.close();
        return atms;
    }

    private List<Task> getRequest(String jsonFile) throws IOException {
        InputStream isRequest = Task.class.getResourceAsStream(jsonFile);
        List<Task> tasks = Arrays.asList(mapper.readValue(isRequest, Task[].class));
        isRequest.close();
        return tasks;
    }
}