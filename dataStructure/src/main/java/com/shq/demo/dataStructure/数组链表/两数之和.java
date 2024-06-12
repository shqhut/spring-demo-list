package com.shq.demo.dataStructure.数组链表;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {

    public int[] twoSum(int[] nums, int target) {
        // nums[i] + nums[j] = target => nums[j] = target - nums[i];
        Map<Integer,Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (valToIndex.containsKey(need)) {
                return new int[]{valToIndex.get(need),i};
            }
            valToIndex.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public int[] twoSum2(int[] nums, int target) {
        int n = 0;
        int[] result = new int[2];
        // nums[0] + nums[1]
        // ...
        // nums[0] + nums[nums.length-1]

        // nums[1] + nums[2]
        // nums[1] + nums[nums.length-1]

        // nums[nums.length-2] + nums[nums.length-1]
        while (n<nums.length-1) {
            // 1 - n.length-1
            for (int i = n+1; i <= nums.length-1; i++) {
                if (nums[n] + nums[i] == target) {
                    result[0] = n;
                    result[1] = i;
                    return result;
                }
            }
            n++;
        }
        return result;
    }

}
