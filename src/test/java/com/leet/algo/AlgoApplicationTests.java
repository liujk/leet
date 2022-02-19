package com.leet.algo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgoApplicationTests {
    public static final long INTERVAL_DAYS = 3;
    public static final ZoneOffset BJ_ZONE = ZoneOffset.of("+8");
    public static final long ONE_DAY_SECONDS = 60 * 60 * 24;

    @Test
    public void contextLoads() {
//        System.out.println(String.format("%xn",69331));
        System.out.println(("804c13ac-d392-11e9-a0bf-6c92bf2cdd05".hashCode() & Integer.MAX_VALUE) % 128);
//        long index = (LocalDate.now().atStartOfDay().toEpochSecond(BJ_ZONE) / ONE_DAY_SECONDS) % INTERVAL_DAYS;
//        System.out.println(index);
    }

}
