package batchfour.teamtwo.renttrailservice.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum StatusRent {

    BOOKED("Booked"),
    BORROWED("Borrowed"),
    DONE("Done");

    private String value;

    StatusRent() {
    }

    StatusRent(String value) {
        this.value = value;
    }

    @JsonCreator
    public static StatusRent fromValue(String value) {
        for (StatusRent statusRent : values()) {
            if (statusRent.value.equalsIgnoreCase(value)) {
                return statusRent;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }
}
