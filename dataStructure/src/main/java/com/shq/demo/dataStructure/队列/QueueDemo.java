package com.shq.demo.dataStructure.队列;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("111");
        queue.add("222");
        queue.add("333");
        queue.add("444");
        String poll = queue.poll();
        System.out.println(poll);
    }

}
