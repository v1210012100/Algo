package com.example.diva.algonote;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class algo11 {
    /***
     * 这道题，可以看成往大小为 3的数组中 填充数字 ，限制条件就是 只能从 数组中取，并且不能重复 。
     * 第一位 可以放3种 ，第二位也可以放 2种 ，第三位也可以放 1 种 。因此会形成这种类似树的结构
     *
     *   解决一个回溯问题，实际上就是一个决策树的遍历过程 。 我们想要的东西是路径而不是节点
     *
     *  1、路径：也就是已经做出的选择。
     *  2、选择列表：也就是你当前可以做的选择。
     *  3、结束条件：也就是到达决策树底层，无法再做选择的条件。
     *
     *  关于决策树的遍历 ： 有两点要注意的
     *  状态回溯 ，也叫状态重置 ，决策树深度遍历，从底部返回上一节点时，需要重置状态 。（ 树的遍历不需要）
     *  保存路径 :自然要删除节点 ，添加节点的时机 和删除 节点 的 时机  发生在 递归函数 的前后 。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        // 用于保存路径，需要添加和移除栈顶元素，所以选择栈
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        backtrack(nums,length,hashSet,stack,res);
        return res;
    }

    /***
     * 这道题的，            选择列表 每次都 是 整个 nums  和 路径 stack  的非交集 。
     * 正式选择列表的存在 ，才出现了回溯操作。
     *
     * @param nums
     * @param len      数组长度
     * @param used     快速检测  stack 中 的数据
     * @param stack    路径
     * @param res
     */
    private void backtrack(int[] nums,  int len, Set<Integer> used, Stack<Integer> stack, List<List<Integer>> res) {

        if(stack.size() == len){
            List<Integer> list = new ArrayList<>(stack);
            res.add(list);
            return;
        }
        for(int i=0;i<len;i++){
            if(!used.contains(nums[i])){
                stack.push(nums[i]);
                used.add(nums[i]);
                backtrack(nums,len,used,stack,res);
                stack.pop();
                used.remove(nums[i]);
            }
        }

    }


}
