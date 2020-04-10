package com.example.diva.algonote;

import java.util.HashMap;

public class algo25 {

    /***
     *    本质上仍然是 暴力解法 ：使用HashSet 来实现快速查询 。
     *   使用滑动窗口来解决这个问题 。  i  和   j
     *   注意滑动窗口移除数据的问题。   更新 i 的坐标
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

    public static void main(String args[]){
         int a = lengthOfLongestSubstring("abba");
         System.out.println(a);
    }
}
