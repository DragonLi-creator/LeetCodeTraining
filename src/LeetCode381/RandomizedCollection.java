package LeetCode381;
import java.util.*;

import java.util.HashMap;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 *
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RandomizedCollection {
    // 当前集合长度
    int n;
    HashMap<Integer,Set<Integer>> map;
    ArrayList<Integer> list;
    Random random;

    public RandomizedCollection() {
        this.random = new Random();
        this.map = new HashMap<Integer, Set<Integer> > ();
        this.n = 0;
        this.list = new ArrayList<>();
    }

    public boolean insert(int val){
        // 从map集合中获取值，如果为空就新建
        Set set = map.get(val);
        if (set == null){
            set = new HashSet();
        }
        // 添加索引
        set.add(n);
        // 添加值
        list.add(val);
        // 存入map
        map.put(val,set);
        // 索引+1，下次插入使用
        n++;
        // 如果集合中只有一个索引，则代表之前没哟插入过，返回true，否则代表已有值，返回false
        return set.size() == 1;
    }
    public boolean remove(int val){
        if (map.containsKey(val)){
            // 得到最后两个索引值
            int lastIndex = n-1;
            Set lastSet = map.get(list.get(lastIndex));
            Set set = map.get(val);
            // 得到当前索引值
            int currentIndex = (int) set.iterator().next();
            swap(list,currentIndex,lastIndex);
            list.remove(n-1);
            // 删除原值
            set.remove(currentIndex);
            if (set.size() == 0){
                map.remove(val);
            }
            // 修改最后一个值的索引
            lastSet.remove(n-1);
            lastSet.add(currentIndex);
            n--;
        }else {
            return false;
        }
        return true;
    }

    public int getRandom(){
        return list.get(random.nextInt(n));
    }
    private void swap(List<Integer> list ,int i,int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

}
