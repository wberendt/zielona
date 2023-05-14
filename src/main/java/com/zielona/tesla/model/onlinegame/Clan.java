package com.zielona.tesla.model.onlinegame;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Clan
 */
public class Clan {
    @JsonProperty("numberOfPlayers")
    private int numberOfPlayers;

    @JsonProperty("points")
    private int points;

    /**
     * Get number of players
     * @return numberOfPlayers
     */
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    /**
     * Set number of players
     * @param numberOfPlayers
     */
    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    /**
     * Get points
     * @return points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Set points
     * @param points
     */
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
