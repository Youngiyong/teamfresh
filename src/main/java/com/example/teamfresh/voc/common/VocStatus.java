package com.example.teamfresh.voc.common;

public enum VocStatus {
    RECEIVE("310"),
    HOLD("320"),
    PROCEED("330"),
    CANCEL("340"),
    COMPLETE("350");

    private String value;

    private VocStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
