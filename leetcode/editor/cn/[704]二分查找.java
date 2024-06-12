
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        // 确定搜索边界为[left,right]
        while (left <= right) {
            // 如何确定中点
            // 1 2 3 4 5 6 7
            // left = 0 right = 6 mid = 3
            // left = 4 right = 6 mid = 5
            // mid中点索引 = left + 数组长度 / 2
            // 1 2 3 4 5 6
            // left = 0 right = 5 mid = 2
            // left = 3 right = 5 mid = 4
            // 难点：链表重点坐标算法
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // left = mid++;
                // left = mid mid = mid + 1
                left = mid + 1;
            } else if (nums[mid] > target) {

                right = mid - 1 ;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
