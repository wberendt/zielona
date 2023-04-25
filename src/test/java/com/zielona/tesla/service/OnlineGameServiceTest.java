package com.zielona.tesla.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zielona.tesla.model.onlinegame.Clan;
import com.zielona.tesla.model.onlinegame.Players;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class OnlineGameServiceTest {

    private ObjectMapper mapper = new ObjectMapper();
    private OnlineGameService onlineGameService = new OnlineGameServiceImpl();

    @Test
    void calculate() throws IOException {
        var players = getRequest("/onlinegame/example_request.json");
        var expectedResult = getResponse("/onlinegame/example_response.json");

        var result = onlineGameService.calculate(players);

        Assertions.assertEquals(expectedResult.size(), result.size());
        var itExpected = expectedResult.iterator();
        var itResult = result.iterator();
        while (itExpected.hasNext()) {
            var elExpected = itExpected.next();
            var elResult = itResult.next();
            Assertions.assertArrayEquals(elExpected.toArray(), elResult.toArray());
        }
    }

    private Players getRequest(String jsonFile) throws IOException {
        InputStream isRequest = Players.class.getResourceAsStream(jsonFile);
        Players players = mapper.readValue(isRequest, Players.class);
        isRequest.close();
        return players;
    }

    private List<List<Clan>> getResponse(String jsonFile) throws IOException {
        Class clazz = Clan[][].class;
        InputStream isResponse = clazz.getResourceAsStream(jsonFile);
        List<List<Clan>> groupsOfClans = mapper.readValue(isResponse, new TypeReference<>(){});
        isResponse.close();
        return groupsOfClans;
    }
}