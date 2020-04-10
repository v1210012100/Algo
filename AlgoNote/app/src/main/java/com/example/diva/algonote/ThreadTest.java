package com.example.diva.algonote;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadTest {

//    public static void main(String[] args) {
//
//        List<? extends Number>  list= new ArrayList<Integer>();
//
//        ExecutorService executor = Executors.newCachedThreadPool();
//        Task task = new Task();
//        Future<Integer> result = executor.submit(task);
//        executor.shutdown();
//
//        //第一种方式
////            ExecutorService executor = Executors.newCachedThreadPool();
////            Task task = new Task();
////            FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
////            executor.submit(futureTask);
////            executor.shutdown();
//
//        //第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
////        Task task = new Task();
////        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
////        Thread thread = new Thread(futureTask);
////        thread.start();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e1) {
//            e1.printStackTrace();
//        }
//
//        System.out.println("主线程在执行任务");
//
//        try {
//            System.out.println("task运行结果" + result.get());
////            System.out.println("task运行结果" + futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("所有任务执行完毕");
//    }
//}
//
//class Task implements Callable<Integer> {
//    @Override
//    public Integer call() throws Exception {
//        System.out.println("子线程在进行计算");
//        Thread.sleep(30000);
//        int sum = 0;
//        for (int i = 0; i < 100; i++)
//            sum += i;
//        return sum;
//    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,2,5,3,1,45,30};
        quickSort(nums,0,nums.length-1);
        for(int i = 0;i<nums.length;i++){
            System.out.print(nums[i]+"，  ");
        }
    }


    /***
     * 快排是交换排序的升级版
     * 交换排序: 基准点的选择， 左边的起始元素为基准点。
     * 分为两个步骤
     * 一、 基准点右部的 数据之间的交换
     *       1 、 右指针先移动 ，找到比基准小的值，左指针后移动找到比基准大的值。 交换
     *       2、 重复上面的步骤， 偶数情况和奇数情况
     *       3、   偶数情况 2   3    1   交换后变成 了   2   1   3  。
     *       交换后，右指针的指向变成了 3 ，它还要找个比二小的 ，移动，然后 又找到了1 。 此时指针相遇了。 左指针就不动了，交换也不用干了
     *       4、 奇数情况  2    3  4   1  交换一次后，变成  2   1  4  3 。 右指针此时指向3 ，跳过 4 和上面情况一样。
     *
     * 二 、最终相遇的位置。 由于 右指针霸道的行为肯定是 小于等于  基准点的 。
     * 三、 基准点 和 左右指针相遇 的位置交换 ,可能是基准点自身 ，如  1   2   3   4
     */











    public static void quickSort(int[] nums,int i ,int j){
        if(i>=j) return;

        int start = i;
        int end = j;
        int compare = nums[start];
        while(i<j){
            while(i<j && nums[j]>=compare){
                j--;
            }
            while(i<j && nums[i]<=compare){
                i++;
            }
            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        nums[start] = nums[i];
        nums[i] = compare;

        quickSort(nums,start,i-1);
        quickSort(nums,i+1,end);
    }

}
