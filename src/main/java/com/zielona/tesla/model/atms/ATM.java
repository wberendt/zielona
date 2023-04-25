package com.zielona.tesla.model.atms;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * ATMs details
 */

public class ATM {

  public ATM() {
  }

  public ATM(int region, int atmId) {
    this.region = region;
    this.atmId = atmId;
  }

  @JsonProperty("region")
  private int region;

  @JsonProperty("atmId")
  private int atmId;

  /**
   * Get region
   * minimum: 1
   * maximum: 9999
   * @return region
  */
  public int getRegion() {
    return region;
  }

  public void setRegion(int region) {
    this.region = region;
  }

  /**
   * Get atmId
   * minimum: 1
   * maximum: 9999
   * @return atmId
  */
  public int getAtmId() {
    return atmId;
  }

  public void setAtmId(int atmId) {
    this.atmId = atmId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ATM atm = (ATM) o;
    return Objects.equals(region, atm.region) && Objects.equals(atmId, atm.atmId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(region, atmId);
  }
}
