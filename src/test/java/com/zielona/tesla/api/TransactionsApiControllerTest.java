package com.zielona.tesla.api;

import com.zielona.tesla.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransactionsApiControllerTest {

    private static final String path = "/transactions/report";

    @MockBean
    private TransactionService transactionService;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void report() {
        var url = UriComponentsBuilder.fromPath(path).toUriString();
        var data = "[]";
        var httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(APPLICATION_JSON);
        HttpEntity<String> requestHttpEntity = new HttpEntity<>(data, httpHeaders);
        var resp = restTemplate.exchange(url, HttpMethod.POST, requestHttpEntity, List.class);
        assertEquals(HttpStatus.OK.value(), resp.getStatusCode().value());
        assertNotNull(resp.getBody());
    }

}