package com.zielona.tesla.model.atms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.zielona.tesla.model.atms.RequestTypeEnum.FAILURE_RESTART;
import static com.zielona.tesla.model.atms.RequestTypeEnum.PRIORITY;
import static com.zielona.tesla.model.atms.RequestTypeEnum.SIGNAL_LOW;
import static com.zielona.tesla.model.atms.RequestTypeEnum.STANDARD;

class RequestTypeEnumTest {

    @Test
    void getValue() {
        var type = RequestTypeEnum.PRIORITY;
        Assertions.assertEquals("PRIORITY", type.getValue());
    }

    @Test
    void getPriority() {
        var type = RequestTypeEnum.SIGNAL_LOW;
        Assertions.assertEquals(2, type.getPriority().intValue());
    }

    @Test
    void testToString() {
        var type = FAILURE_RESTART;
        Assertions.assertEquals("FAILURE_RESTART", type.toString());
    }

    @Test
    void fromValue() {
        var type = RequestTypeEnum.fromValue("STANDARD");
        Assertions.assertEquals(RequestTypeEnum.STANDARD, type);
    }

    @Test
    void fromValueExceptionExpected() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> RequestTypeEnum.fromValue("UNKNOWN_TYPE")
        );
    }

    @Test
    void values() {
        RequestTypeEnum[] expectedValues = new RequestTypeEnum[] {
                FAILURE_RESTART,
                PRIORITY,
                SIGNAL_LOW,
                STANDARD
        };

        Assertions.assertArrayEquals(expectedValues, RequestTypeEnum.values());
    }

    @Test
    void valueOf() {
        Assertions.assertEquals(RequestTypeEnum.SIGNAL_LOW, RequestTypeEnum.valueOf("SIGNAL_LOW"));
    }
}