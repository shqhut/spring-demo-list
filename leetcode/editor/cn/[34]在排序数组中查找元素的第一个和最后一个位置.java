
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 二分查找
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }
        // 先找出左边界
        int leftBound = leftBound(nums, target);
        if (leftBound == -1) {
            return new int[]{-1,-1};
        }
        // 寻找右边界
        int rightBound = rightBound(nums, target, leftBound);
        return new int[]{leftBound,rightBound};
    }

    public int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            // 搜索区间[left,right)，终止条件left==right
            int mid = left + (right - left)/2;
            if (nums[mid] >= target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    public int rightBound(int[] nums, int target, int left) {
        int right = nums.length;
        while (left < right) {
            // 搜索区间[left,right)，终止条件left==right
            int mid = left + (right - left)/2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left-1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
