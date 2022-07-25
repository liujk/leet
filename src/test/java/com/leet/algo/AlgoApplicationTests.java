package com.leet.algo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgoApplicationTests {
    public static final long INTERVAL_DAYS = 3;
    public static final ZoneOffset BJ_ZONE = ZoneOffset.of("+8");
    public static final long ONE_DAY_SECONDS = 60 * 60 * 24;

    @Test
    public void test() throws IOException {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine().toLowerCase();
        String second = sc.nextLine().toLowerCase();
        System.out.println(first.length() - first.replaceAll(second, "").length());
    }

    @Test
    public void contextLoads() {
        System.out.println(String.format("%x", 419));
//        System.out.println(String.format("%xn",69331));
        System.out.println("8ac683d66e8d0eef026e8e4888030044".hashCode() & 0x7F);
//        long index = (LocalDate.now().atStartOfDay().toEpochSecond(BJ_ZONE) / ONE_DAY_SECONDS) % INTERVAL_DAYS;
//        System.out.println(index);

        String key = "yu23wp$@yh3416rf";
        AES aes = new AES(key);
//        System.out.println(aes.decrypt("s/eTgIH+P1K/tJEgtAGVGA=="));
        System.out.println(aes.encrypt("18100383675", key));
//        System.out.println(aes.decrypt("s/eTgIH+P1K/tJEgtAGVGA=="));
//
//        String digest = MD5.getMessageDigest("bxChannel=" + bxChannel +
//                "&timestamp=" + timestamp + "&sourceCode=" + sourceCode + "&identityNo=" + identityNo + md5Salt);
    }

}
