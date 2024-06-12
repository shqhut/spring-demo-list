package com.shq.demo.dataStructure.数组链表;


import java.util.Iterator;

/**
 * 基于双向链表实现的LinkedList
 * @param <E>
 */
public class MyLinkedList<E> implements Iterable<E> {

    /**
     * 链表头节点（哨兵节点），值是什么不重要
     */
    public Node<E> head;

    /**
     * 链表尾节点（哨兵节点），值是什么不重要
     */
    public Node<E> tail;

    /**
     * 链表元素数量
     */
    public int size;

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E val = p.data;
                p = p.next;
                return val;
            }
        };
    }

    /**
     * 定义一个节点
     * @param <E>
     */
    public static class Node<E> {

        public E data;

        public Node<E> next;

        public Node<E> prev;

        public Node(E value) {
            data = value;
        }

    }

    public MyLinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFirst(E e) {
        // 待插入元素
        Node<E> x = new Node<>(e);
        Node<E> temp = head.next;
        // head节点next指向x，temp的prev指向x
        x.next = temp;
        x.prev = head;

        head.next = x;
        temp.prev = x;
        size++;
    }

    public void addLast(E e) {
        Node<E> x = new Node<>(e);
        Node<E> temp = tail.prev;
        x.next = head;
        x.prev = temp;

        tail.prev = x;
        temp.next = x;
        size++;
    }

    public void add(int index, E e) {
        // 考虑边界问题
        checkPosition(index);
        Node<E> x = new Node<>(e);
        if (index == size) {
            addLast(e);
            return;
        }
        Node<E> node = getNode(index);
        node.prev.next = x;
        node.next.prev = x;
        x.next = node.next;
        x.prev = node.prev;

        node.next = null;
        node.prev = null;
        size++;
    }

    public E removeFirst() {
        // 链表为空
        if (isEmpty()) {
            throw new RuntimeException("linkedList is empty");
        }
        Node<E> x = head.next;
        Node<E> temp = x.next;
        // head <-> x <-> temp => head <-> temp
        head.next = temp;
        temp.prev = head;

        x.next = null;
        x.prev = null;
        size--;
        return x.data;
    }

    /**
     * 双向链表优势，可以从尾部操作链表
     * @return
     */
    public E removeLast() {
        // 链表为空
        if (isEmpty()) {
            throw new RuntimeException("linkedList is empty");
        }
        // 待删除的元素
        Node<E> x = tail.prev;
        Node<E> temp = x.prev;
        // temp <-> x <-> tail => temp <-> tail
        temp.next = tail;
        tail.prev = temp;

        x.prev = null;
        x.next = null;
        size--;
        return tail.prev.data;
    }

    /**
     * 将元素插到指定位置，并返回原来的原属
     * @param index
     * @param e
     * @return
     */
    public E set(int index, E e) {
        checkPosition(index);
        Node<E> node = new Node<>(e);
        Node<E> x = getNode(index);
        x.prev.next = node;
        x.next.prev = node;

        node.prev = x.prev;
        node.next = x.next;

        x.prev = null;
        x.next = null;
        return x.data;
    }

    public Node<E> getNode(int index) {
        Node<E> p = head.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    private void checkPosition(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index:" + index + "size:" + size);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index:" + index + "size:" + size);
        }
    }

    public Boolean isEmpty() {
        return size == 0;
    }
}
