package com.leet.algo.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jkliu
 * @description
 * @create 2021-11-09 2:01 PM
 **/
public class QuickSort {
    public static void quickSort(int[] a, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }

    public static int partition(int[] a, int low, int high) {
        int pivotKey = a[low];

        while (low < high) {
            while (low < high && a[high] >= pivotKey) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= pivotKey) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = pivotKey;
        return low;
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        boolean flag = true;
        //random array
        for (int i = 0; i < a.length; i++) {
            Random rd = new Random();
            a[i] = rd.nextInt(1000);
        }
        System.out.println("Random Array :");
        System.out.println(Arrays.toString(a));
        System.out.println();
        System.out.println("Quick Sort :");
        //快速排序开始
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
