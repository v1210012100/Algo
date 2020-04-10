package com.example.diva.algonote;
// 647 题
public class algo12 {

    /***
     * 回文子串
     * 先考虑子串问题：子串的区间为 【i,j】
     *  解法一、
     *  暴力法： 双重循环 ，第一层 子串的长度 ，第二层 子串 i 的起始位置
     *
     *  解法二、
     *  动态规划
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int n = 0;
        char[] chars= s.toCharArray();
        for(int i = 0; i<s.length();i++){
            for(int j =0;j<s.length();j++){
                if(j+i<s.length()&&isOk(chars,j,j+i)){
                    n++;
                }
            }
        }
        return n;

    }
    public boolean isOk(char[] s,int i,int j){
        while(i<j){
            if(s[i]!=s[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
