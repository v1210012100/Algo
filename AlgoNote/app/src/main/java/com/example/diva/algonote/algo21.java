package com.example.diva.algonote;

public class algo21 {

    /***
     * 最简单的动态规划 。
     * 计算出 每个以 i 结尾的 最大 和 序列 。
     * 再 求出 最大 的 那个i
     * 这两部可以合成一步 ，省略掉 存储空间
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int endWithMeMax = 0;
        for(int i = 0;i<nums.length;i++){
            if(endWithMeMax<0){
                endWithMeMax = nums[i];
            }else{
                endWithMeMax = nums[i] + endWithMeMax;
            }
            max = Math.max(max,endWithMeMax);
        }
        return max;
    }
}
