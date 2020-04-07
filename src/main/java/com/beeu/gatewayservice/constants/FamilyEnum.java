package com.beeu.gatewayservice.constants;

public enum FamilyEnum {

    SHARED("SHARED", "Shared", "Shared plan (FREE)"),
    PRIVATE("PRIVATE", "Private", "Private plan (2.99$ / month)");

    private String code;
    private String name;
    private String description;

    FamilyEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
