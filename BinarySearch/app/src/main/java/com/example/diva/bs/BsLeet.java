package com.example.diva.bs;

// 一文解决 4 道「搜索旋转排序数组」题！
//定义里说的是将一些数放到后面，没有说不可以把全部数都放到后面 。这种会干扰我们的判断。
//https://github.com/cy69855522/Shortest-LeetCode-Python-Solutions
// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/yi-wen-jie-jue-4-dao-sou-suo-xuan-zhuan-pai-xu-s-2/
//https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/c-dai-ti-kan-bu-dong-de-numsmid-numsleft-miao-sha-/
/***
 *
 *  一句话： 找最小值 。是排除掉有序的部分，最后只有 一个数的时候就是 最小值。
 *  查找问题，是在有序的部分进行二分查找。如果目标值不在有序部分。则 将范围缩小为另一部分。重复。
 *
 */
public class BsLeet {

    /***
     *   有重复情况的，右比较版本
     * @param nums
     * @return
     */
    public int findMinDualRight(int[] nums) {
        int left=0;
        int right =nums.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]<nums[right]){
                right = mid;
            }else if(nums[mid]>nums[right]){
                left = mid+1;
            }else{
                right--;
            }
        }
        // 跳出循环的时候 ，left = right
        return left;
    }



    /***
     *  mid  和 left 比较 ： 特殊情况，查找范围缩小至2 个数时 ， left pos == mid pos
     *  由于 在计算mid 前 ，已经  判断过一个 查找范围是否是全翻转（ 全部有序），所以 可以直接返回 right。
     * @param nums
     * @return
     */
    public int findMinLeft(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            if(nums[left] < nums[right]) return nums[left] ;
            int mid = left +(right-left)/2;
            if(nums[mid] > nums[left]){
                left = mid+1;
            }else if(nums[mid]==nums[left]){
                return right;
            }else{
                 right = mid;
            }
        }
        return left;
    }


    /***
     * 有重复数字 的左比较版本 。 也是可以成功运行的
     * @param nums
     * @return
     */
    public int findMinDualLeft(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            if(nums[left] < nums[right]) return nums[left] ;
            int mid = left +(right-left)/2;
            if(nums[mid] > nums[left]){
                left = mid+1;
            }else if(nums[mid]==nums[left]){
                if(mid== left){
                    return nums[right];
                }else{
                    left++;
                }

            }else{
                right = mid;
            }
        }
        return nums[left];
    }






    //--------------  查找问题-----------------------------------------------------------------------------------------


    /***
     *  无重复数字的查找问题 ， 左比较版本 。
     *   需要注意 ，target 为边界值 ，和 只剩两个数字时 ，mid 和 left 重合的问题 。
     * @param nums
     * @param target
     * @return
     */
    public int searchNoduLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > nums[left]){
                if( target>=nums[left] && target<nums[mid]){
                    // 由于上面已经判断过  nums[mid] == target 。
                    //  target 可能为边界的值 ，需要带上 = 号 。
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else if(nums[mid] == nums[left]){
                // 在无重复的情况下，这 代表 只剩一个 或者 2 个数字了 。并且 mid  不是要找的人 。
                left++;
            }else{
                if( target>nums[mid] && target<=nums[right]){
                    //  target 可能为边界的值 ，需要带上 = 号
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }


    /***
     *  无重复数字的查找问题 ，右比较 版本 ： 和左比较的不同是 ，mid 的 pos 只有在 只存在一个数的时候  == right
     * @param nums
     * @param target
     * @return
     */
    public int searchNoduRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > nums[right]){
                if( target>=nums[left] && target<nums[mid]){
                    // 由于上面已经判断过  nums[mid] == target 。
                    //  target 可能为边界的值 ，需要带上 = 号 。
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else if(nums[mid] == nums[right]){
                // 在无重复的情况下，这 代表 只剩 一个数字了 并且 不为 target 。
                return  -1;
            }else{
                // nums[mid] < nums[right]
                if( target>nums[mid] && target<=nums[right]){
                    //  target 可能为边界的值 ，需要带上 = 号
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }


    /***
     *  带重复数字的 ，左查找 。
     *  重复数字的影响：
     * @param nums
     * @param target
     * @return
     */
    public boolean searchDuLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] > nums[left]){
                if( target>=nums[left] && target<nums[mid]){
                    // 由于上面已经判断过  nums[mid] == target 。
                    //  target 可能为边界的值 ，需要带上 = 号 。
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else if(nums[mid] == nums[left]){
                // 有重复数字的情况下，需要判断是 由于 mid == left  还是 。重复数字
                if(mid == left){
                    left++;
                }else{
                    // 好消息 ，还是 left ++ 。
                    left++;
                }

            }else{
                if( target>nums[mid] && target<=nums[right]){
                    //  target 可能为边界的值 ，需要带上 = 号
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return true;
    }

    /***
     * 带重复数字 的右查找版本
     * @param nums
     * @param target
     * @return
     */
    public boolean searchDuRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] > nums[right]){
                if( target>=nums[left] && target<nums[mid]){
                    // 由于上面已经判断过  nums[mid] == target 。
                    //  target 可能为边界的值 ，需要带上 = 号 。
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else if(nums[mid] == nums[right]){
                // 重复情况下 ，可能 是 搜索 范围 只有 1个了 ，也可能是重复。
                right--;
            }else{
                // nums[mid] < nums[right]
                if( target>nums[mid] && target<=nums[right]){
                    //  target 可能为边界的值 ，需要带上 = 号
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return false;
    }

}
