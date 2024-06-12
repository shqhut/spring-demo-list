package com.shq.demo.dataStructure.数组链表;

import java.util.NoSuchElementException;

public class MyArrayList<E> {

    // 真正存数据的
    private E[] data;

    // 记录当前数组中原始的个数
    private int size;

    /**
     * 在index插入element，之后的元素后移
     * @param index
     * @param e
     * @return
     */
    public void add(int index, E e) {
        // 考虑index是否越界
        checkPositionIndex(index);
        System.arraycopy(data,index,data,index+1,size-index);
        data[index] = e;
        size++;
    }

    public E get(int index) {
        // 考虑index是否越界
        checkElementIndex(index);
        return data[index];
    }

    /**
     * 将index改为element，并将原来的元素返回
     * @param index
     * @param e
     * @return
     */
    public E set(int index, E e) {
        checkElementIndex(index);
        E oldElement = data[index];
        data[index] = e;
        return oldElement;
    }

    public E remove(int index) {
        checkElementIndex(index);
        // 1、元素搬移，data[index+1..] -> data[index]
        System.arraycopy(data, index+1, data, index, size-index-1);
        // 2、移除元素
        E removeElement = data[index];
        data[index] = null;
        size--;
        return removeElement;
    }

    public E removeLast() {
        // 考虑边界问题，data是否为空
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        // 考虑集合缩容
        if (size < data.length / 4) {
            resize(data.length / 2);
        }
        E deleteValue = data[size-1];
        // 将最后一个位置空，原本引用的原素就变成垃圾对象了，会被GC，防止内存泄漏
        data[size-1] = null;
        size--;
        return deleteValue;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    /**
     * 将数组大小扩容或缩容
     * @param newCap
     */
    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];
        // 将data中的元素复制到temp中
        System.arraycopy(data,0,temp,0,size);
        data = temp;
    }

    /**
     * 新增元素时，index范围是0-size
     * @param index
     */
    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
    }

    /**
     * 操作元素时，index范围是0-size-1
     * @param index
     */
    private void checkElementIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
    }


}
