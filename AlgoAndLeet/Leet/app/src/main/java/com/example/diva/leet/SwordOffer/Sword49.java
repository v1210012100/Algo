package com.example.diva.leet.SwordOffer;

public class Sword49 {

    /***
     * 丑数 * 2   ，3  ，5  得到的数必定是丑数。
     * 丑数问题的三指针方案。
     * 为什么需要三个指针 。  指针代表的是有有资格乘   2   ，  3    ，5 的数 。他们可以是同一个，也可以是不同的 。最初 1   有资格乘  2,3,5
     * 选出 最小的 2 后， 1 失去了 乘以 2 的资格。   然后 第二小的丑数就是刚刚的2  。2 有资格乘  2  3   5   。但是 乘 3  5 坑定比   1 乘的大 。
     *
     *每次我们都分别比较有资格同2，3，5相乘的最小丑数，
     * 选择最小的那个作为下一个丑数，假设选择到的这个丑数是同i（i=2，3，5）相乘得到的，所以它失去了同i相乘的资格，把对应的pi++，让pi指向下一个丑数即可。
     *
     *
     * 如果使用堆的话，需要保证没有添加重复的元素。需要用Set 去重 。
     * 计算用到的数组 nums，堆 heap 和哈希表 seen 跟踪在堆中出现过的元素，避免重复
     * 弹出堆中最小的数字 k 并添加到数组 nums 中。
     * 若 2k，3k，5k 不存在在哈希表中，则将其添加到栈中并更新哈希表。
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int temp = 1;

        for (int i = 1; i < n; i++) {
            temp = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = temp;

            if (temp == nums[i2] * 2) {
                i2++;
            }
            if (temp == nums[i3] * 3) {
                i3++;
            }
            if (temp == nums[i5] * 5) {
                i5++;
            }
        }

        return nums[n - 1];
    }

}
