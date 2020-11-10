package LeetCode1281;
import	java.util.ArrayList;

import java.util.List;

public class Main {
    static List<Integer> list = new ArrayList<Integer> ();
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }
    public static int subtractProductAndSum(int n) {
        int res1 = 1;
        int res2 = 0;
        while(n>0){
            int num = n % 10;
            n /= 10;
            res1 *= num;
            res2 += num;
        }
        return (res1 - res2);

    }
}
