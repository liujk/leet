package com.leet.algo.dp;

import java.util.*;

/**
 * @author jkliu
 * @description
 * @create 2021-10-28 11:15 AM
 **/
public class No22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n <= 0){
            return res;
        }
        getParenthesis("",n,n);
        return res;
    }

    private void getParenthesis(String str,int left, int right) {
        if(left == 0 && right == 0 ){
            res.add(str);
            return;
        }
        if(left == right){
            //剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str+"(",left-1,right);
        }else if(left < right){
            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if(left > 0){
                getParenthesis(str+"(",left-1,right);
            }
            getParenthesis(str+")",left,right-1);
        }
    }

    /**
     * 动态规划
     */
    public static List<String> generateParenthesis1(int n) {
        LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
        if (n == 0) {
            return result.get(0);
        }
        LinkedList<String> list0 = new LinkedList<String>();
        list0.add("");
        result.add(list0);
        LinkedList<String> list1 = new LinkedList<String>();
        list1.add("()");
        result.add(list1);
        for (int i = 2; i <= n; i++) {
            LinkedList<String> temp = new LinkedList<String>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" + s2;
                        temp.add(el);
                    }
                }

            }
            result.add(temp);
        }
        return result.get(n);
    }


    /**
     * 回溯算法
     */
    public static List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        Stack<String> track = new Stack<>();

        backtrack(n, n, res, track);
        return res;
    }

    private static void backtrack(int left, int right, List<String> res, Stack<String> track) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> iterator = track.iterator();
            while (iterator.hasNext()) {
                sb.append(iterator.next());
            }
            res.add(sb.toString());
        }
        track.push("(");
        backtrack(left - 1, right, res, track);
        track.pop();

        track.push(")");
        backtrack(left, right - 1, res, track);
        track.pop();
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis1(3);
        list.forEach(e -> System.out.println(e));
    }
}
