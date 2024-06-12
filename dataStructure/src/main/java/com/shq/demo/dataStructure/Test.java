package com.shq.demo.dataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {



    public void changeArray(int[] arr, int a) {
        arr[2] = 5;
        a = 11;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4};
        int a = 10;
        System.out.println(arr[2]); // 4
        Test test = new Test();
        test.changeArray(arr,a);
        System.out.println(arr[2]); // 5
        System.out.println(a); // 10

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));

    }

    public static class Node {
        Integer val;

        Node next;

        public Node(Integer val) {
            this.val = val;
        }
    }
}
