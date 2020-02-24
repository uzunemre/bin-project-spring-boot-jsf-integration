package com.emreuzun.bank.core.model.enumaration;

public enum EntityStatusEnum {

    P("Pasif"),
    A("Aktif");

    private String message;

    EntityStatusEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
