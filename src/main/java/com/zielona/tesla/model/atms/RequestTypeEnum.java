package com.zielona.tesla.model.atms;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Map;

/**
 * Request type
 */
public enum RequestTypeEnum {
    FAILURE_RESTART("FAILURE_RESTART"),
    PRIORITY("PRIORITY"),
    SIGNAL_LOW("SIGNAL_LOW"),
    STANDARD("STANDARD");

    private String value;

    private static final Map<String, Integer> priority = Map.of(
            "FAILURE_RESTART", 0,
            "PRIORITY", 1,
            "SIGNAL_LOW", 2,
            "STANDARD", 3
    );

    /**
     * Constructor
     * @param value
     */
    RequestTypeEnum(String value) {
        this.value = value;
    }

    /**
     * Get value
     * @return value
     */
    @JsonValue
    public String getValue() {
        return value;
    }

    /**
     * Get priority
     * @return priority
     */
    public Integer getPriority() {
        return priority.get(this.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static RequestTypeEnum fromValue(String value) {
        for (RequestTypeEnum b : RequestTypeEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
