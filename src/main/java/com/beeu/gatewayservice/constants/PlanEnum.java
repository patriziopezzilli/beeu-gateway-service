package com.beeu.gatewayservice.constants;

import java.util.Arrays;
import java.util.List;

public enum PlanEnum {

    STANDARD("STANDARD", "Standard", Arrays.asList(FamilyEnum.SHARED)),
    ADVANCED("ADVANCED", "Advanced", Arrays.asList(FamilyEnum.SHARED, FamilyEnum.PRIVATE)),
    PROFESSIONAL("PROFESSIONAL", "Pro", Arrays.asList(FamilyEnum.SHARED, FamilyEnum.PRIVATE));

    private String code;
    private String name;
    private List<FamilyEnum> families;

    PlanEnum(String code, String name, List<FamilyEnum> families) {
        this.code = code;
        this.name = name;
        this.families = families;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<FamilyEnum> getFamilies() {
        return families;
    }
}
