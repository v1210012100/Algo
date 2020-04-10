package com.example.diva.leet.ByteDanceLeet;
//https://leetcode-cn.com/problems/trapping-rain-water/
// 接雨水
public class LeetCode42 {

    /***
     * 暴力解法是求出每个 柱子的左 边最大，右边最大的 柱子 。然后就可以计算出该柱子的积水
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length-1;
        int sum = 0;
        // 双指针法 。 计算什么时候结束 ，计算出每个柱子 上的积水后结束
        //  关于指针的 条件是 left<=right   。 每一次循环会计算出一个柱子的水。<= 保证 每个柱子都的到了计算
        //  2<3  然后 计算 2 这个柱子 。 然后 2++ 后就跳出循环了 ，3柱子没有计算。
        while(left<=right){
            leftMax = Math.max(height[left],leftMax);
            rightMax = Math.max(height[right],rightMax);
            if(leftMax<=rightMax){
                sum = sum+ leftMax-height[left];
                left++;
            }else{
                sum = sum + rightMax- height[right];
                right--;
            }
        }
        return sum;
    }

    /***
     * 优化的暴力解法。
     * @param height
     * @return
     */
//    public int trap2(int[] height) {
//
//    }
}
