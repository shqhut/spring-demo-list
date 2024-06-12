package com.shq.demo.dataStructure.数组链表;

import java.util.Iterator;

/**
 * 基于单向链表实现
 */
public class MyLinkedList2<E> implements Iterable<E> {

    private Node<E> head;

    private Node<E> tail;

    private Integer size;

    public static class Node<E> {

        public E data;

        public Node<E> next;

        public Node(E data){
            this.data = data;
        }

    }

    public MyLinkedList2() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    // 增
    public void addFirst(E e) {
        Node<E> x = new Node<>(e);
        Node<E> temp = head.next;
        head.next = x;
        x.next = temp;
        size++;
    }


    public void addLast(E e) {
        Node<E> x = new Node<>(e);
        // 遍历链表
        for (Node<E> p = head.next; p != tail; p = p.next) {
            if (p.next == tail) {
                p.next = x;
                x.next = tail;
                return;
            }
        }
        size++;
    }

    // 删
//    public E removeFirst() {
//
//    }
//
//    public E removeLast() {
//
//    }
//
//    public E removeIndex(int index, E e) {
//
//    }
//
//    // 改
//    public E setIndex(int index, E e) {
//
//    }
//
//    // 查
//    public E peek() {
//
//    }
//
//    public E getIndex(int index) {
//
//    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index:" + index + "size:" + size);
        }
    }

    private void checkPosition(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index:" + index + "size:" + size);
        }
    }

}
