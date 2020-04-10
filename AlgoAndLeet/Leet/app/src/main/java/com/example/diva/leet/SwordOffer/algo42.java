package com.example.diva.leet.SwordOffer;

public class algo42 {
    /***
     * 连续子数组的最大和。
     *   以 dp  代表以   i 结尾的子数组的最大 和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sumMax=0;
        int before =0;
        int cur =0;
        for(int i=0;i<nums.length;i++){
            if(i==0) {
                sumMax = nums[0];
                before = sumMax;
            }else{
                if(before<=0){
                    sumMax =Math.max(sumMax,nums[i]);
                    before = nums[i];
                }else{
                    cur = nums[i]+before;
                    sumMax =Math.max(sumMax,cur);
                    before = cur;
                }
            }
        }
        return sumMax;
    }
}
