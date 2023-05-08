package com.zielona.tesla.model.atms;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RegionTest {
    List<ATM> listOfAtms;

    @BeforeEach
    void before() {
        listOfAtms = new ArrayList<>();
    }

    @AfterEach
    void after() {
        listOfAtms = null;
    }

    @Test
    void addAtm() {
        var region = new Region(1, 1);
        region.addAtm(2, 2);
        region.fill(listOfAtms, 1);

        Assertions.assertEquals(2, listOfAtms.size());
        Assertions.assertEquals(1, listOfAtms.get(0).getRegion());
        Assertions.assertEquals(1, listOfAtms.get(0).getAtmId());
        Assertions.assertEquals(1, listOfAtms.get(1).getRegion());
        Assertions.assertEquals(2, listOfAtms.get(1).getAtmId());
    }

    @Test
    void fill() {
        var region = new Region(1, 2);
        region.fill(listOfAtms, 1);

        Assertions.assertEquals(1, listOfAtms.size());
        Assertions.assertEquals(1, listOfAtms.get(0).getRegion());
        Assertions.assertEquals(2, listOfAtms.get(0).getAtmId());
    }
}