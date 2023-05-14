package com.zielona.tesla.model.onlinegame;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Players
 */
public class Players {
    @JsonProperty("groupCount")
    private Integer groupCount;

    @JsonProperty("clans")
    private List<Clan> clans;

    /**
     * Get number of players in single group
     * @return
     */
    public Integer getGroupCount() {
        return groupCount;
    }

    /**
     * Set number of players in single group
     * @param groupCount
     */
    public void setGroupCount(Integer groupCount) {
        this.groupCount = groupCount;
    }

    /**
     * Get list of clans
     * @return clans
     */
    public List<Clan> getClans() {
        return clans;
    }

    /**
     * Set list of clans
     * @param clans
     */
    public void setClans(List<Clan> clans) {
        this.clans = clans;
    }
}
