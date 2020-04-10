package com.example.diva.algonote;
// 268 题
public class algo15 {
    /***
     * 神奇的位运算 。
     *  x ^ x   = 0
     *  0 ^x = x
     *  并且异或满足交换律和结合率
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int temp=n;
        for(int i =0;i<n;i++){
            temp = temp^nums[i]^i;
        }
        return temp;
    }
}
