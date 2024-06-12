
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
}
//leetcode submit region end(Prohibit modification and deletion)
