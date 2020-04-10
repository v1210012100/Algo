package com.example.diva.leet.SwordOffer;

import java.util.HashMap;

public class Sword48 {

    /***
     * 最长不含重复字符。
     * 经典的双指针 。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max=0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hashMap.containsKey(s.charAt(i))){
                int pos = hashMap.get(s.charAt(i));
                if(pos>=left){
                    left = pos+1;
                }
            }
            hashMap.put(s.charAt(i),i);
            right = i;
            max = Math.max(right-left+1,max);
        }
        return max;
    }
}
