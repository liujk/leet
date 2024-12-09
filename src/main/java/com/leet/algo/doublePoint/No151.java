package com.leet.algo.doublePoint;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class No151 {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            char c = s.charAt(i);
            while (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
                sb.append(c);
                i++;
                if (i == s.length()) {
                    break;
                }
                c = s.charAt(i);
            }
            if (sb.length() > 0) {
                list.add(0, sb.toString());
            }
        }
       return list.stream().collect(Collectors.joining(" "));
    }
}
