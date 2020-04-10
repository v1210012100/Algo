package com.example.diva.leet.SwordOffer;

import java.util.LinkedList;

public class Sword59_2 {

    /***
     * 带最大值功能的队列
     *
     * 采用一个正常队列 和一个辅助队列
     *
     * java 中 的双端队列 工具类有哪些
     *  存储结构为 链表的 有LinkedList
     *  存储结构为 数组的有 ArrayDeque
     */
    public static class MaxQueue {
        LinkedList<Integer> help = new LinkedList();
        LinkedList<Integer> dates = new LinkedList<>();
        public MaxQueue() {

        }

        public int max_value() {
            return dates.isEmpty() ? -1 : help.peek();
        }

        public void push_back(int value) {
            dates.add(value);
            while(!help.isEmpty() && help.peekLast()<=value){
                help.removeLast();
            }
            help.add(value);
        }

        public int pop_front() {
            if(dates.isEmpty()) return -1;
            if(dates.peek().equals(help.peek())){
                dates.pop();
                return help.pop();
            }else{
                return dates.pop();
            }
        }
    }
}


