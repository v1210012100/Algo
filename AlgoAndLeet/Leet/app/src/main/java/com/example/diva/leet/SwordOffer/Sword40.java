package com.example.diva.leet.SwordOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Sword40 {
    /***
     * 大顶堆，
     * 最小大n 个数用大顶堆。
     * 最大的 n 个数，用小顶堆。
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0)return new int[0];
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                return o2-o1;
            }
        });
        for(int i =0;i<k;i++){
            heap.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(arr[i]<heap.peek()){
                heap.poll();
                heap.add(arr[i]);
            }
        }
        int [] re = new int [k];
        for(int i =0;i<k;i++){
            re[i] = heap.poll();
        }
        return re;
    }
}
