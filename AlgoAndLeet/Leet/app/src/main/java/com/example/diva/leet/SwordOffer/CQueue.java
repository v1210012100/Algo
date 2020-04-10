package com.example.diva.leet.SwordOffer;

import java.util.Stack;

/***
 * 用栈模拟队列的缺点
 * 由于栈访问 栈底的元素 需要 O N 的时间复杂度 。
 * 所以插入和删除 必须有一个是 O N 的时间复杂度 。
 * 要么栈顶放 Head 。要么栈底放Head。
 * 队列还是用链表表示方便。
 *
 *
 *
 *  由于Queue 的功能比较单一只有尾部添加。和 头部删除 。
 *
 * -------------------解法一 。stack1 负责保管所有的数据 。  栈顶为头部 。那么 添加 到尾部时，要全部出栈。添加新数据 ，再全部入栈 。时间复杂度 O N *2
 */
class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    public CQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        size = 0;
    }

    public void appendTail(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        size++;
    }

    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        size--;
        return stack1.pop();
    }
}


/***
 * ----------------- 解法二 。Stack1 扶着 入栈 。 Stack2 负责 出栈 。
 */
//class CQueue {
//
//    private Stack<Integer> stack1;
//    private Stack<Integer> stack2;
//
//    public CQueue() {
//        stack1 = new Stack<>();
//        stack2 = new Stack<>();
//    }
//
//    public void appendTail(int value) {
//        stack1.push(value);
//    }
//
//    public int deleteHead() {
//        if (stack1.isEmpty() && stack2.isEmpty())
//            return -1;
//        if (stack2.isEmpty()){
//            while (!stack1.isEmpty()) {
//                stack2.push(stack1.pop());
//            }
//        }
//        return stack2.pop();
//    }
//}




