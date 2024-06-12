
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // 利用二分法查找
        // 第一步：确认自变量的范围
        int left = 0;
        int right = 1;
        for (int w:weights) {
            left = Math.max(left, w);
            right += w;
        }
        // 第二步：开始二分查找，搜索左边界，确认搜索区间
        while (left < right) {
            int mid = left + (right-left)/2;
            if (f(weights,mid) <= days) {
                right = mid;
            } else if (f(weights,mid) > days) {
                left = mid + 1;
            }
        }
        return left;
    }

    // 二分查找泛化 f(x) = target
    // 自变量为 运载能力
    // target为days天
    // 推导出target是x的单调减关系
    public int f(int[] weights, int x) {
        int days = 0;
        for (int i=0; i<weights.length;) {
            int cap = x;
            while (i<weights.length) {
                if (cap<weights[i]) {
                    break;
                } else {
                    cap -= weights[i];
                }
                i++;
            }
            days++;
        }
        return days;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
