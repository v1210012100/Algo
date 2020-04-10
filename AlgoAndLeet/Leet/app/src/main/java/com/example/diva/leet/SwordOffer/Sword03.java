package com.example.diva.leet.SwordOffer;

// 利用了桶排序的思想 ， 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1  。如果进行排序，那么每个数的位置正好是它的下标
public class Sword03 {
    public int findRepeatNumber(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            while(nums[i]!= i){
                // 说明 nums[i]  的位置不正确 。 将这个值放到它该去的位置
                int temp = nums[nums[i]];
                if(temp == nums[i]){
                    // 撞车了
                    return temp;
                }
                nums[nums[i]] = nums[i];
                // 有来了一个新的值。看看正不正确
                nums[i] = temp;
            }
        }
        return -1;
    }
}
