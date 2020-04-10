package com.example.diva.leet.SwordOffer;

public class Sword60 {

    /***
     * https://www.cnblogs.com/wangkundentisy/p/9378886.html
     * 求所有可能性的概率 。
     * dp 代表的是  方法 。 dp [2][6]  是 用 两个色子 扔出 6 的的情况 。
     * n个骰子的点数依赖于n-1个骰子的点数 。相当于在n-1个骰子点数的基础上再进行投掷。
     * f(n,k)=f(n−1,k−1)+f(n−1,k−2)+f(n−1,k−3)+f(n−1,k−4)+f(n−1,k−5)+f(n−1,k−6)
     *  子问题的初始解为
     *  f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1
     * @param n
     * @return
     */
    public double[] twoSum(int n) {
        int [][]dp = new int[n+1][6*n+1];
        //边界条件
        for(int s=1;s<=6;s++)dp[1][s]=1;
        for(int i=2;i<=n;i++){
            for(int s=i;s<=6*i;s++){
                //求dp[i][s]
                for(int d=1;d<=6;d++){
                    if(s-d<i-1)break;//为0了
                    dp[i][s]+=dp[i-1][s-d];
                }
            }
        }
        double total = Math.pow((double)6,(double)n);
        double[] ans = new double[5*n+1];
        for(int i=n;i<=6*n;i++){
            ans[i-n]=((double)dp[n][i])/total;
        }
        return ans;
    }
}
