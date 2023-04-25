package com.zielona.tesla.model.onlinegame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Test
    void getGroupCount() {
        var players = new Players();
        players.setGroupCount(111);
        Assertions.assertEquals(111, players.getGroupCount());
    }

    @Test
    void getClans() {
        var clan1 = new Clan();
        clan1.setPoints(22);
        clan1.setNumberOfPlayers(11);

        var clan2 = new Clan();
        clan2.setPoints(22);
        clan2.setNumberOfPlayers(11);

        var clansExpected = List.of(
                clan1
        );
        var clans = List.of(
                clan2
        );

        var players = new Players();
        players.setClans(clans);

        Assertions.assertArrayEquals(clansExpected.toArray(), players.getClans().toArray());
    }
}