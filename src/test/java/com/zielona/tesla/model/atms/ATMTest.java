package com.zielona.tesla.model.atms;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    @Test
    void getRegion() {
        var atm = new ATM(123,234);
        Assertions.assertEquals(123, atm.getRegion());
    }

    @Test
    void setRegion() {
        var atm = new ATM();
        atm.setRegion(123);
        Assertions.assertEquals(123, atm.getRegion());
    }

    @Test
    void getAtmId() {
        var atm = new ATM(1, 234);
        Assertions.assertEquals(234, atm.getAtmId());
    }

    @Test
    void setAtmId() {
        var atm = new ATM();
        atm.setAtmId(1122);
        Assertions.assertEquals(1122, atm.getAtmId());
    }

    @Test
    void testEquals() {
        var atm1 = new ATM(123, 456);
        var atm2 = new ATM(123, 456);
        Assertions.assertEquals(atm1.hashCode(), atm2.hashCode());
    }

    @Test
    void testHashCode() {
        var atm1 = new ATM(123,234);
        var atm2 = new ATM(123,234);
        Assertions.assertEquals(atm1.hashCode(), atm2.hashCode());
    }
}