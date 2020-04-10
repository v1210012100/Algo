package com.example.diva.leet.SwordOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Sword59 {
    /***
     *  两种解法 ，
     *  一 、 维护一个大顶堆
     *  二 、 维护一个双端队列 ，并保证双端队列是递减的，所以头部最大。
     *  新插入的元素时： 检测 头部是否被移除， 移除所有比新元素小的 元素 。因为他们没用了
     *  这个双端队列的长度是比 窗口大小k 要小的 。
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null||nums.length==0) return new int[0];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i =0;i<k;i++){
            priorityQueue.add(nums[i]);
        }
        int[] re = new int[nums.length-k+1];
        re[0] = priorityQueue.peek();
        for(int i =k;i<nums.length;i++){
            priorityQueue.remove(nums[i-k]);
            priorityQueue.add(nums[i]);
            re[i-k+1] = priorityQueue.peek();
        }
        return re;
    }
}
