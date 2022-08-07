package com.leet.algo.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jkliu
 * @description
 * @create 2022-07-28 10:18 AM
 **/
public class No77 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || k < 1) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> track = new ArrayList<>();
        backTrack(n, k, 1, track);
        return res;

    }

    void backTrack(int n, int k, int start, List<Integer> track) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backTrack(n, k, i + 1, track);
            track.remove(track.size() - 1);
        }
    }
}
