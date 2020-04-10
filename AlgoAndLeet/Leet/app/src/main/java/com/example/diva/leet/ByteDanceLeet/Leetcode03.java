package com.example.diva.leet.ByteDanceLeet;

import java.util.HashMap;

public class Leetcode03 {
    /***
     * 无重复字符的最长子串
     * 重复问题使用 HashMap
     * 子串问题 ，常用的也就是滑动窗口 ，双指针
     * 滑动窗口检测到有重复字符 ，需要更新窗口 ，也就是双指针的 左侧坐标 。
     * 更新HashMap 。有两种方法 ，一种是 删除法，保证存储的永远是当前窗口里的 字符 。
     * 一种是 判断重复的 位置是否有效
     *
     *  和官方题解不同 ，我的滑动窗口是 两端都闭合的    大小为   i-left+1
     *
     *  当 重复产生了 ，并且有效
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left =0;
        int max = 0;
        for(int i =0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){

                // 为什么这个地方是 + 1 ，是有讲究的
//                left = Math.max(map.get(s.charAt(i))+1, left);
                if(map.get(s.charAt(i))>=left){
                    // 当重复后 ，重复的那个字符肯定不能要了 。所以 left 要在重复位置前面一位
                    left = map.get(s.charAt(i)) +1;
                }
            }
            map.put(s.charAt(i),i);
            max = Math.max(i-left+1,max);
        }
        return max;
    }

}
