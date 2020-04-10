package com.example.diva.algonote;

// 9
public class algo13 {

    /***
     * 关于 Int 的数学问题 需要记得 溢出的情况
     *  回文问题: 如果折半判断 ，需要考虑奇偶性
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x<0 || x%10 == 0 && x!=0) return false;
        int reversNum = 0;
        while(x >reversNum){
            reversNum = reversNum*10 + x%10;
            x= x/10;
        }
        return (x==reversNum || x== reversNum/10);
    }
}
