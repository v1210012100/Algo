package com.example.diva.leet.SwordOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Sword41 {

    /***
     *  数据流中的中位数
     *  当总数为奇数时，中位数是中间的那个
     *  当总数为偶数时，中位数是中间两个的平均数。
     *
     *  解法一、插入排序 。 插入的时间复杂度 是 O N 。
     *
     *  要解决插入时间的问题 。就只能用堆。
     *
     *  两个堆
     *  大顶堆保存： 较小的元素
     *  小顶堆保存： 较大的元素 。
     *  并且保证： 小顶堆的数比    大顶堆的大 ---------------只有保证了这个前提 ，才能 保证两个堆顶是中位数
     *  如何保证上一步呢，当一个新的元素加入时，先加入左边的，大顶堆 。    然后再把大顶堆，堆顶的数交给        右边 。
     *  这样就保证了 。 右边比左边的数大 。
     *  那么怎么 维护平衡呢:------------上面的操作，右边始终比左边多1 。那么当总数为偶数的时候 ， 从右边的堆顶，拿一个最小的还给左边。
     *
     */
    class MedianFinder {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
        int size= 0;
        /** initialize your data structure here. */
        public MedianFinder() {
            left = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            size++;
            left.add(num);
            right.add(left.poll());
            if(size%2==0){
                left.add(right.poll());
            }
        }

        public double findMedian() {
            if(size%2==0){
                // 注意浮点数输出。
                return (left.peek()+right.peek())/2.0;
            }else{
                return right.peek();
            }
        }
    }

}
