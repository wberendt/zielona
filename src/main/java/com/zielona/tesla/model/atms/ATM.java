package com.zielona.tesla.model.atms;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * ATM
 */
public class ATM {

  /**
   * Constructor
   */
  public ATM() {
  }

  /**
   * Constructor
   * @param region
   * @param atmId
   */
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
   * @return region
   */
  public int getRegion() {
    return region;
  }

  /**
   * Set region
   * @param region
   */
  public void setRegion(int region) {
    this.region = region;
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
