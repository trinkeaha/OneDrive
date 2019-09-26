package com.trinke.onedrive.common.menum;

public enum Renum {
    SUCCESS(200),ERROR(400);
    private int code;
    private Renum(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
