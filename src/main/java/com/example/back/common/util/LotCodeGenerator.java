package com.example.back.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LotCodeGenerator {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHH");

    public static String generateCurrentDatePrefix() {
        return LocalDateTime.now().format(DATE_FORMAT);
    }
}