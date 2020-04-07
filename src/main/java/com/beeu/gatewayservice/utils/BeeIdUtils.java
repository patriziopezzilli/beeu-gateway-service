package com.beeu.gatewayservice.utils;

public class BeeIdUtils {

    public static Long extractId(String beeId) {
        return Long.valueOf(beeId.replace("BEE-", ""));
    }
}
