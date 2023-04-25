package com.zielona.tesla.model.onlinegame;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Players {
    @JsonProperty("groupCount")
    private Integer groupCount;

    @JsonProperty("clans")
    private List<Clan> clans;

    public Integer getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(Integer groupCount) {
        this.groupCount = groupCount;
    }

    public List<Clan> getClans() {
        return clans;
    }

    public void setClans(List<Clan> clans) {
        this.clans = clans;
    }
}
