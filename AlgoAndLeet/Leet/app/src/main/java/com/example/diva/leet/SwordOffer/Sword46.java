package com.example.diva.leet.SwordOffer;

/***
 * 把数字翻译成字符串
 * 这tm 谁能想到。
 */
public class Sword46 {

    /***
     * 这道题和 爬楼梯很像 。 可以一次转两个数，也可以一次转一个数。
     *  f(n) = f(n-1)  当  n  和 n-1 个 字母不能 两个合成一个 ，那么就只有 一种转法 。
     *  f(n) =  f(n-1) + f(n-2)    。  n   和 n-1 可以 合成一个。
     * @param num
     * @return
     */
    public int translateNum(int num) {
        int left =1;
        int right =1;
        int next = 0;
        String s = num+"";
        if(s.length()<=1) return 1;
        for(int i =1;i<s.length();i++){
            if(s.charAt(i-1)=='0'|| Integer.parseInt(s.substring(i-1,i+1))>25){
                next = right;
                left = right;
                right = next;
            }else{
                next = right+left;
                left = right;
                right = next;
            }
        }
        return next;
    }
}
