package com.shq.demo.dataStructure.数组链表.前缀和数组;

public class PivotIndex {

    public int pivotIndex(int[] nums) {
        // 数组前缀
        int[] preNum = new int[nums.length+1];
        for (int i = 1; i < nums.length+1; i++) {
            preNum[i] = preNum[i-1] + nums[i];
        }
        int x = 1;
        while (x <= nums.length) {
            if (preNum[x-1] == preNum[nums.length]-preNum[x] ) {
                return x-1;
            }
        }
        return -1;
    }

}
