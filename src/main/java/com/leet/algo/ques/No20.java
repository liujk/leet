package com.leet.algo.ques;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author jkliu
 * @description
 * @create 2021-12-04 4:39 PM
 **/
public class No20 {
    public boolean isValid(String s) {
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('(', ')');
        bracketMap.put('{','}');
        bracketMap.put('[',']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (bracketMap.keySet().contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                }
               if (!bracketMap.get(stack.pop()).equals(s.charAt(i))) {
                   return false;
               }
            }
        }

        return stack.empty();
    }
}
