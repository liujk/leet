package com.leet.algo.doublePoint;

public class No125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chars = new char[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                chars[index++] = c;
            }
        }
        for (int i = 0; i < index; i++) {
            if (chars[i] != chars[index - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
