package LeetCode127;
import	java.util.LinkedList;
import	java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String>wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
       if (!wordList.contains(endWord)){
           // 不包含变换单词，直接返回0
           return 0;
       }
       boolean[] visited = new boolean[wordList.size()];
       // 找打开始单词的索引下标
       int index = wordList.indexOf(beginWord);
       if (index != -1){
           visited[index] = true;
       }
       Queue<String> queue = new LinkedList<>();
       queue.offer(beginWord);
       int count = 0;
       while (queue.size() > 0){
           int size  = queue.size();
           ++count;
           while (size-- > 0){
               String start = queue.poll();
               for (int i = 0; i < wordList.size(); ++i) {
                   // 通过 index 判断是否已经访问
                   if (visited[i]) {
                       continue;
                   }
                   String s = wordList.get(i);
                   if (!canConvert(start, s)) {
                       // 不可替换单词，结束这次循环
                       continue;
                   }
                   if (s.equals(endWord)) {
                       // 如果这次匹配最后一个单词，则直接返回变换次数+1
                       return count + 1;
                   }
                   // 标记访问过
                   visited[i] = true;
                   queue.offer(s);
               }

           }
       }
       return 0;
    }
    public static boolean canConvert(String s1, String s2) {
        // 因为题目说了单词长度相同，可以不考虑长度问题
        // if (s1.length() != s2.length()) return false;
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                // 每有一个不匹配，就加1
                ++count;
                if (count > 1) {
                    return false;
                }
            }
        }
        // 若两个单词只有一个字母不匹配，则返回true，可替换
        return count == 1;
    }

}
