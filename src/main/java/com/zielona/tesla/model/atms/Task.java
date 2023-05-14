package com.zielona.tesla.model.atms;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Task
 */
public class Task {

    @JsonProperty("region")
    private int region;

    @JsonProperty("requestType")
    private RequestTypeEnum requestType;

    @JsonProperty("atmId")
    private int atmId;

    /**
     * Get region ID
     * @return region
     */
    public int getRegion() {
        return region;
    }

    /**
     * Set region ID
     * @param region
     */
    public void setRegion(int region) {
        this.region = region;
    }

    /**
     * Get request type
     * @return requestType
     */
    public RequestTypeEnum getRequestType() {
        return requestType;
    }

    /**
     * Set request type
     * @param requestType
     */
    public void setRequestType(RequestTypeEnum requestType) {
        this.requestType = requestType;
    }

    /**
     * Get ATM ID
     * @return atmId
     */
    public int getAtmId() {
        return atmId;
    }

    /**
     * Set ATM ID
     * @param atmId
     */
    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }
}
