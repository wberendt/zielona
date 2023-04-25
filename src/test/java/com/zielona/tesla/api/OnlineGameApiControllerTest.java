package com.zielona.tesla.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zielona.tesla.model.onlinegame.Players;
import com.zielona.tesla.service.OnlineGameService;
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
class OnlineGameApiControllerTest {

    private static final String path = "/onlinegame/calculate";
    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private OnlineGameService onlineGameService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void calculate() throws JsonProcessingException {
        var url = UriComponentsBuilder.fromPath(path).toUriString();
        var data = """
              {
                  "groupCount": 1,
                  "clans": [
                    {
                      "numberOfPlayers": 1,
                      "points": 1
                    }
                  ]
              }
            """;
        var players = mapper.readValue(data, Players.class);
        var httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(APPLICATION_JSON);
        HttpEntity<Players> requestHttpEntity = new HttpEntity<>(players, httpHeaders);

        var resp = restTemplate.exchange(url, HttpMethod.POST, requestHttpEntity, List.class);
        assertEquals(HttpStatus.OK.value(), resp.getStatusCode().value());
        assertNotNull(resp.getBody());
    }
}