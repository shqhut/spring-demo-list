
//leetcode submit region begin(Prohibit modification and deletion)
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
        // preNums比nums长
        // 如果想要计算nums[1]-nums[4]之间的元素 相当于num[4]-nums[0]
        // 相当于preNums[5]-preNums[1]
        return preNums[right+1] - preNums[left];
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)
