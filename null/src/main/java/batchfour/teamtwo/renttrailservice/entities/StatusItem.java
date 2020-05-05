package batchfour.teamtwo.renttrailservice.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum StatusItem {

    PENDING("Pending"),
    ALLOWED("Allowed"),
    DENIED("Denied");

    private String value;

    StatusItem() {
    }

    StatusItem(String value) {
        this.value = value;
    }

    @JsonCreator
    public static StatusItem fromValue(String value) {
        for (StatusItem statusItem : values()) {
            if (statusItem.value.equalsIgnoreCase(value)) {
                return statusItem;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }
}
