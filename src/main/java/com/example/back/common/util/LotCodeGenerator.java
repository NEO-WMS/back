package com.example.back.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;
@Component
public class LotCodeGenerator {

    private final AtomicInteger currentSequence = new AtomicInteger(0);
    private String currentDateString = getCurrentDateString();

    public synchronized String generateLotCode() {
        String newDateString = getCurrentDateString();

        if (!newDateString.equals(currentDateString)) {
            currentDateString = newDateString;
            currentSequence.set(0);
        }

        int sequenceNumber = currentSequence.incrementAndGet();
        String sequenceString = String.format("%04d", sequenceNumber);

        return currentDateString + "-" + sequenceString;
    }

    private String getCurrentDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(new Date());
    }
}