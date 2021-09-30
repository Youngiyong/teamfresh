package com.example.teamfresh.voc.common;

public enum VocStatus {
    RECEIVE(310),
    APPROVE(320),
    PROCEED(330),
    HOLD(340),
    COMPLETE(350),
    CANCEL(360);
    private int value;

    private VocStatus(int value) {
        this.value = value;
    }

}
