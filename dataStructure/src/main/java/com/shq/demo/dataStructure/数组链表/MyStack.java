package com.shq.demo.dataStructure.数组链表;

import java.util.LinkedList;

public class MyStack<E> {

    LinkedList<E> linkedList = new LinkedList<>();

    public void push(E e) {
        linkedList.addFirst(e);
    }

    public E pop() {
        return linkedList.removeFirst();
    }

    public E peek() {
        return linkedList.peek();
    }
}
