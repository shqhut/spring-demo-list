
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minInsertions(String s) {
        // 需要插入(的次数
        int res = 0;
        // 需要插入)的次数
        int need = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                need = need+2;
                if (need % 2 == 1) {
                    // 需要)的数量为奇数
                    res++;
                    need--;
                }
            }
            if (s.charAt(i) == ')') {
                need--;
                if (need == -1) {
                    res++;
                    need = 1;
                }
            }
        }
        return res+need;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
