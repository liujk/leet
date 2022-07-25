package com.nowcoder;

import java.io.IOException;
import java.util.*;

/**
 * @author jkliu
 * @description
 * @create 2022-07-22 10:37 AM
 **/
public class HJ5 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] array = new String[num];
        for (int i = 0; i < num; i++) {
            array[i] = sc.next();
        }

        Arrays.sort(array);
        for (String key : array) {
            System.out.println(key);
        }
    }

}
