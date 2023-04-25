package com.zielona.tesla.model.onlinegame;

import com.zielona.tesla.model.atms.ATM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClanTest {

    @Test
    void getNumberOfPlayers() {
        var clan = new Clan();
        clan.setNumberOfPlayers(123);
        Assertions.assertEquals(123, clan.getNumberOfPlayers());
    }

    @Test
    void getPoints() {
        var clan = new Clan();
        clan.setPoints(234);
        Assertions.assertEquals(234, clan.getPoints());
    }

    @Test
    void testEquals() {
        var clan1 = new Clan();
        clan1.setNumberOfPlayers(22);
        clan1.setPoints(44);

        var clan2 = new Clan();
        clan2.setNumberOfPlayers(22);
        clan2.setPoints(44);

        Assertions.assertEquals(clan1, clan2);
    }

    @Test
    void testHashCode() {
        var clan1 = new Clan();
        clan1.setNumberOfPlayers(22);
        clan1.setPoints(44);

        var clan2 = new Clan();
        clan2.setNumberOfPlayers(22);
        clan2.setPoints(44);
        Assertions.assertEquals(clan1.hashCode(), clan2.hashCode());
    }
}