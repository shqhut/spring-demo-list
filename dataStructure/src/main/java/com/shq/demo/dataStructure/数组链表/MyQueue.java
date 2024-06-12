package com.shq.demo.dataStructure.数组链表;

public class MyQueue<E> {

    MyLinkedList<E> linkedList = new MyLinkedList<>();

    /**
     * 在队尾插入原素
     * @param e
     */
    public void enqueue(E e) {
        linkedList.addLast(e);
    }

    /**
     * 在队头弹出一个元素
     * @return
     */
    public E dequeue() {
        return linkedList.removeFirst();
    }

    /**
     * 查看队头第一个元素
     * @return
     */
    public E peek() {
        return linkedList.getNode(0).data;
    }

}
