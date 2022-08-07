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
        String first = sc.nextLine();
        String second = sc.nextLine();

        if (first.length() > second.length()) {
            String temp = first;
            first = second;
            second = temp;
        }
        int index = 0, maxLen = 0;
        for (int i = 0; i < first.length(); i++) {
            if (i + maxLen > first.length()) {
                break;
            }
            for (int j = first.length() - i; j > 0; j--) {
                if (second.indexOf(first.substring(i, i + j)) > -1) {
                    if (j > maxLen) {
                        index = i;
                        maxLen = j;
                    }
                    break;
                }
            }
        }
        System.out.println(maxLen == 0 ? "" : first.substring(index, index + maxLen));
    }

    public boolean isValid (String s) {
        Character firstLeft = '(';
        Character firstRight = ')';
        Character secondLeft = '{';
        Character secondRight = '}';
        Character thirdLeft = '[';
        Character thirdRight = ']';

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Set<Character> leftSet = map.keySet();

        int len = s.length();
        Deque<Character> deque = new LinkedList<Character>();
        for (int i = 0; i < len; i++) {
            if (leftSet.contains(s.charAt(i))) {
                deque.push(s.charAt(i));
            } else if (!deque.isEmpty() && map.get(deque.peek()).equals(s.charAt(i))) {
                deque.pop();
            } else {
                return false;
            }
        }
        return deque.isEmpty();
    }

}
