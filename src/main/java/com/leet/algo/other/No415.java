package com.leet.algo.other;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 **/
public class No415 {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        StringBuilder sb = new StringBuilder();
        int maxLength = num1.length() > num2.length() ? num1.length() : num2.length();
        int carry=0;
        for (int i = 0; i < maxLength; i++) {
            int first = num1.length()-1-i >= 0 ? num1.charAt(num1.length()-1-i) -'0' : 0;
            int second = num2.length()-1-i >= 0 ? num2.charAt(num2.length()-1-i) - '0' : 0;
            int total = first + second + carry;
            sb.append(total % 10);
            carry = total / 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        No415 no415 = new No415();
        System.out.println(no415.addStrings("456", "77"));
    }
}
