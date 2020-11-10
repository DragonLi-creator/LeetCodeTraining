package LeetCode941;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(validMountainArray(nums1));
    }

    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int max = A[0];
        int index = 0;
        for (int i = 1; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
                index = i;
            }
        }
        if (index >= A.length - 1 || index <= 0) {
            return false;
        }
        for (int i = 0; i < index; i++) {
            if (A[i] >= A[i + 1]) {
                return false;
            }
        }
        for (int i = index; i < A.length - 1; i++) {
            if (A[i] <= A[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
