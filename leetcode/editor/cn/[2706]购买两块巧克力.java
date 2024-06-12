
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int buyChoco(int[] prices, int money) {
        // [1,2,2,7,4,1] 3
        // 获取最小的两个元素，排序
        // 冒泡排序
        for (int i = prices.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                // 边界考虑思路：数组下标不能越界，price要能覆盖所有元素
                if (prices[j] > prices[j+1]) {
                    int temp = prices[j];
                    prices[j] = prices[j+1];
                    prices[j+1] = temp;
                }
            }
        }
        // prices依次递增
        int need = prices[0] + prices[1];
        return need <= money ? money - need : money;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
