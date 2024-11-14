package com.leet.algo;

import com.leet.common.GenXinEncryptUtil;
import com.leet.common.PayEncryptUtil;
import com.leet.common.SafeObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public void contextLoads() throws Exception {
//        System.out.println(System.currentTimeMillis());
//        System.out.println(String.format("%x", 419));
//        System.out.println(String.format("%xn",69331));
        //重庆第一分正式 37
//        System.out.println("111d0dc8-3901-11eb-a57e-1c34da501814".hashCode() & 0x7F);
        //重庆第一分测试 127
        System.out.println("402802ec7c747676017d1974898b495f".hashCode() & 0x7F);
//        long index = (LocalDate.now().atStartOfDay().toEpochSecond(BJ_ZONE) / ONE_DAY_SECONDS) % INTERVAL_DAYS;
//        System.out.println(index);
        String key = "yu23wp$@yh3416rf";
//        String key = "Jbspn42dbelvngkn";
        AES aes = new AES(key);
        System.out.println("Basic " + new String(Base64.getEncoder().encode("ea3a38637653386f04ac15f5:1a26c61350d237e42872f14b".getBytes()), Charset.forName("utf-8")));
    }
}
