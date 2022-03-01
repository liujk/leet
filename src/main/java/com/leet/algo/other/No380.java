package com.leet.algo.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author jkliu
 * @description
 * @create 2022-02-22 9:46 PM
 **/
public class No380 {
    class RandomizedSet {
        private HashMap<Integer, Integer> valToIndex;
        private ArrayList<Integer> list;

        public RandomizedSet() {
            valToIndex = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (valToIndex.containsKey(val)) {
                return false;
            }
            valToIndex.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!valToIndex.containsKey(val)) {
                return false;
            }
            int index = valToIndex.get(val);
            int lastVal = list.get(list.size() - 1);
            list.set(index, lastVal);
            list.remove(list.size() - 1);
            valToIndex.put(lastVal, index);
            valToIndex.remove(val);
            return true;
        }

        public int getRandom() {
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }
    }
}
