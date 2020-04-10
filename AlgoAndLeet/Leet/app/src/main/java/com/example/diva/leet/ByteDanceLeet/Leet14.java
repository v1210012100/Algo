package com.example.diva.leet.ByteDanceLeet;

public class Leet14 {

    /***
     * 暴力解法
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String pre = strs[0];
        for(int i=1;i<strs.length;i++){
            int j = 0;
            while(i<pre.length() && i<strs[i].length()){
                if(pre.charAt(j) == strs[i].charAt(j)){
                    j++;
                }else{
                    break;
                }
            }
            if(j==0) return "";
            pre = pre.substring(0,j);
        }
        return  pre;

    }
}
