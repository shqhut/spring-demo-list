
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // k -> x; h -> target
    }

    // 吃掉所有香蕉耗时h跟吃香蕉速度k的关系
    public int f(int[] piles, int k) {
        int k = 0;
        for (int i = 0; i < piles.length; i++) {
             k+=piles[i]/k;
             if (piles[i]%k != 0) {
                 k++;
             }
        }
        return k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
