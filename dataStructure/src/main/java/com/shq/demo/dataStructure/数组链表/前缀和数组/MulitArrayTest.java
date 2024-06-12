package com.shq.demo.dataStructure.数组链表.前缀和数组;

public class MulitArrayTest {

    public static void main(String[] args) {
        int[][] array = {{2,5,-1,6,7},{4,6,9,0,8},{2,5,1,4,3}};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }

}
