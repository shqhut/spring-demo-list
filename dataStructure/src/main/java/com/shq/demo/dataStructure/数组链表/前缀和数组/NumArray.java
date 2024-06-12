package com.shq.demo.dataStructure.数组链表.前缀和数组;

public class NumArray {

    int[] preNums;
    int[] nums;

    public NumArray(int[] nums) {
        // 转化为一个前缀和的数组
        // preNums[0] = 0 方便计算
        this.preNums = new int[nums.length+1];
        for (int i = 1; i < preNums.length; i++) {
            preNums[i] = preNums[i-1] + nums[i-1];
        }
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        return preNums[right+1] - preNums[left];
    }

}
