package com.example.diva.leet.ByteDanceLeet;

public class Leet14 {

    /***
     * 最长公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            // 由于是寻找公共前缀
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;

    }
}
