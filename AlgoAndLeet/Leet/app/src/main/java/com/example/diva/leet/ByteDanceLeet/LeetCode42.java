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
     * 通过两次遍历 。获取 第 i个 柱子的左边 最 高的柱子 ，和 右边最 高的柱子。 这个最高的柱子 是不含自身比较的。
     * 所以需要两个数组来保存 。
     * 一个重要的点： 第 一个柱子和最后一个柱子的顶部是不会有水的 。
     *  Maxleft [i]      i= 2   。也就是计算第一个  0  1 个的最高的 。 由于之前  1 没参加计算。所以它要参加了
     *
     * @param height
     * @return
     */
   public int trap2(int[] height) {
        if(height.length<2) return 0;
        int maxLeft[] = new int[height.length];
        int maxRight[] = new int[height.length];
        for(int i =1;i<height.length-1;i++){
            maxLeft[i] = Math.max(maxLeft[i-1],height[i-1]);
        }
       for(int i =height.length-2;i>0;i--){
           maxRight[i] = Math.max(maxRight[i+1],height[i+1]);
       }
       int sum =0;
       for(int i =1;i<height.length-1;i++){
           int max = Math.min(maxLeft[i],maxRight[i]);
           if(max>height[i]){
               sum = sum+ (max-height[i]);
           }
       }
       return  sum;
  }
}
