package com.zielona.tesla.model.atms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void getRegion() {
        var task = new Task();
        task.setRegion(123);
        Assertions.assertEquals(123, task.getRegion());
    }

    @Test
    void getRequestType() {
        var task = new Task();
        task.setRequestType(RequestTypeEnum.SIGNAL_LOW);
        Assertions.assertEquals(RequestTypeEnum.SIGNAL_LOW, task.getRequestType());
    }

    @Test
    void getAtmId() {
        var task = new Task();
        task.setAtmId(234);
        Assertions.assertEquals(234, task.getAtmId());
    }
}