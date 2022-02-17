package com.timnjonjo.digilend.infra;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;
import java.util.Date;

/**
 * @author TMwaura on 16/02/2022
 * @Project digilend
 */
public class Helper {

    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static Date getNewDateAfterAddingDays(Integer daysToAdd) {
        if (daysToAdd == null || daysToAdd == 0) {
            return new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, daysToAdd);
        return calendar.getTime();
    }


}
