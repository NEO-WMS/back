package com.example.back.common.util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ChangeDateFormatUtil {

    public static String getCurrentDatetiem() {
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        return simpleDateFormat.format(now);
    }
}
