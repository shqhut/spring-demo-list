
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int pivotIndex(int[] nums) {
        // 数组前缀
        int[] preNum = new int[nums.length+1];
        // 计算nums的前缀和
        for (int i = 1; i < nums.length+1; i++) {
            preNum[i] = preNum[i-1] + nums[i-1];
        }
        int x = 1;
        while (x <= nums.length) {
            if (preNum[x-1] == preNum[nums.length]-preNum[x] ) {
                return x-1;
            }
            x++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
