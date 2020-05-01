package batchfour.teamtwo.renttrailservice.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum StatusTransaction {

    BOOKED("Booked"),
    BORROWED("Borrowed"),
    DONE("Done");

    private String value;

    StatusTransaction() {
    }

    StatusTransaction(String value) {
        this.value = value;
    }

    @JsonCreator
    public static StatusTransaction fromValue(String value) {
        for (StatusTransaction statusTransaction : values()) {
            if (statusTransaction.value.equalsIgnoreCase(value)) {
                return statusTransaction;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }
}
