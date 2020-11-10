package Letcode349;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,5,9};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] res = intersection(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                }
            }
        }
        int[] res = new int[list.size()];
        int n = 0;
        for (int i : list) {
            res[n] = i;
            n++;
        }
        return res;
    }
}
