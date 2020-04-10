package com.example.diva.leet.ByteDanceLeet;

public class LeetCode04 {

    /***
     * 寻找两个有序数组的中位数
     * 双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = 0;
        int right = 0;
        int sumLength = nums1.length + nums2.length;
        int pt1 = 0;
        int pt2 = 0;
        // 循环的次数
        for(int i =0;i<=sumLength/2;i++){
            left = right;
            // 注意其中一个数组已经遍历完成的情况
            if( pt2>=nums2.length || (pt1<nums1.length && nums1[pt1]<= nums2[pt2])){
                right = nums1[pt1];
                pt1++;
            }else{
                right = nums2[pt2];
                pt2++;
            }
        }
        // 数据类型的转换 ，输出浮点型 ， 计算却用的整形
        if(sumLength%2==0) return (double) (right+left)/2;
        return right;
    }


}
