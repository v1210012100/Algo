package com.example.diva.leet.SwordOffer;

/***
 * 贪心算法
 * 最高优先级： 3 。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,20,1,2 三种情况。
 * 次高优先级： 2。若最后一段绳子长度为 2，则保留，不再拆为 1+1。 直接乘 2
 * 最低优先级： 1； 若最后一段绳子长度为 1；则应把最后的 3 + 1替换为 2 + 2，因为 2×2>3×1。    也就是 Math.pow(3, a - 1) * 4;
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/mian-shi-ti-14-ii-jian-sheng-zi-iitan-xin-er-fen-f/
 */
public class Sword14 {


    /***
     *  循环
     *  n= 1   :1
     *  n=2    :1
     *  n=3    :3
     *  n=4    :4
     *  n=5    :3*2
     *  n=6    :3*3
     *  n=7    :3*4
     *   所以当 n > 4 后  就是 不断* 3 再乘余数的过程 。
     * @param n
     * @return
     */
    public int integerBreak(int n) {
//        if(n <= 3) return n - 1;
//        int a = n / 3, b = n % 3;
//        if(b == 0) {
//            // n  == 3k   k》=2
//            return (int)Math.pow(3, a);
//        }else if(b == 1){
//            //  n = 3k +1   k >=1
//            return (int)Math.pow(3, a - 1) * 4;
//        }else{
//            //  n = 3k + 2   k >=1
//            return (int)Math.pow(3, a) * 2;
//        }

        if (n==1 || n==2)
            return 1;
        if (n==3)
            return 2;
        int sum=1;
        while (n>4){
            sum*=3;
            n-=3;
        }

        return sum*n;

    }

    class Solution {

        /***
         * 减绳子二，由于存在溢出的情况，所以每一步都进行取余数
         * @param n
         * @return
         */
        public int cuttingRope(int n) {
            if(n == 2)
                return 1;
            if(n == 3)
                return 2;
            long res = 1;
            while(n > 4){
                res *= 3;
                res = res % 1000000007;
                n -= 3;
            }
            return (int)(res * n % 1000000007);
        }
    }


}
