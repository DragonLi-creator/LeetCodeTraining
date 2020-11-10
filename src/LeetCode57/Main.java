package LeetCode57;
import	java.util.ArrayList;
import	java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> list = new ArrayList<> ();
        for (int[] interval : intervals){
            if (interval[0] > right){
                // 在插入区间右侧，且无交集
                if (!placed){
                    list.add(new int[] {left, right});
                    placed = true;
                }
            }else if(interval[1] < left){
                // 在插入区间左侧且无交集
                list.add(interval);
            } else {
                // 有交集
                left = Math.min(left, interval[0]);
                right = Math.max(right,interval[1]);
            }
        }
        if (!placed){
            list.add(new int[] {left,right});
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
