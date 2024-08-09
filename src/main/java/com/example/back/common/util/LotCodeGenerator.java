package com.example.back.common.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LotCodeGenerator {

    private static final AtomicInteger currentSequence = new AtomicInteger(0);
    private static String currentDateString = getCurrentDateString();

    public static synchronized String generateLotCode() {
        String newDateString = getCurrentDateString();

        if (!newDateString.equals(currentDateString)) {
            currentDateString = newDateString;
            currentSequence.set(0);
        }

        int sequenceNumber = currentSequence.incrementAndGet();
        String sequenceString = String.format("%04d", sequenceNumber);

        return currentDateString + "-" + sequenceString;
    }

    private static String getCurrentDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(new Date());
    }
}
