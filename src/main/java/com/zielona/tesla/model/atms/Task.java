package com.zielona.tesla.model.atms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {

    @JsonProperty("region")
    private int region;

    @JsonProperty("requestType")
    private RequestTypeEnum requestType;

    @JsonProperty("atmId")
    private int atmId;

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public RequestTypeEnum getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestTypeEnum requestType) {
        this.requestType = requestType;
    }

    public int getAtmId() {
        return atmId;
    }

    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }
}
