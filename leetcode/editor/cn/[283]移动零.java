
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        // 双指针，快慢指针
        int fast = 0,slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0 || nums[fast] < nums[slow]) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
