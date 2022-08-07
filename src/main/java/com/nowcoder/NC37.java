package com.nowcoder;


import java.util.*;

/**
 * @author jkliu
 * @description
 * @create 2022-07-27 10:46 AM
 **/
public class NC37 {


    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }

        intervals.sort(Comparator.comparing(e -> e.start));
        ArrayList<Interval> list = new ArrayList<>();
        list.add(intervals.get(0));
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (last.end >= intervals.get(i).start) {
                last.end = Integer.max(intervals.get(i).end, last.end);
            } else {
                list.add(intervals.get(i));
                last = intervals.get(i);
            }
        }
        return list;
    }

    public static int getLongestPalindrome(String A) {
        if (A.length() < 2) {
            return A.length();
        }
        boolean[][] dp = new boolean[A.length()][A.length()];
        int max = 0;
        int length = A.length();
        for (int j = 1; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                if (A.charAt(i) != A.charAt(j)) {
                    continue;
                }
                if (j - i <= 2) {
                    dp[i][j] = true;
                    max = Integer.max(max, j - i + 1);
                } else if (dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    max = Integer.max(max, j - i + 1);
                }

            }
        }

        return max;
    }

    public String minWindow (String S, String T) {
        if (T.length() > S.length()) {
            return "";
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < T.length(); i++) {
            need.put(T.charAt(i), need.getOrDefault(T.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, valid = 0, start = 0, len = Integer.MAX_VALUE;
        while (right < S.length()) {
            char r = S.charAt(right);
            right++;
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    valid++;
                }
            }
            while (valid >= need.size()) {
                 if (right - left < len) {
                     start = left;
                     len = right - left;
                 }
                char l = S.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (window.get(l).equals(need.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : S.substring(start, start + len);
    }


    public static void main(String[] args) {
        System.out.println(getLongestPalindrome("daadadcdaddcdbbbdbcddbabcbcaaacdcbadadaccdbcbdbabbbcccbbbdacbaaabbcbdbaaabbcdbcdbbcacdabcdadadcbbcaabddaadddacbaabbcb"));
    }
}

