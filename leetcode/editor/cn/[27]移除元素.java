
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
        // 快慢指针
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
