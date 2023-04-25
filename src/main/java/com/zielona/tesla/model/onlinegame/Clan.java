package com.zielona.tesla.model.onlinegame;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Clan {
    @JsonProperty("numberOfPlayers")
    private int numberOfPlayers;

    @JsonProperty("points")
    private int points;

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clan clan = (Clan) o;
        return numberOfPlayers == clan.numberOfPlayers && points == clan.points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfPlayers, points);
    }
}
