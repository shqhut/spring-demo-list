
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        int left = 0;
        int right = 0;
        String result = "";
        while (right < haystack.length()) {
            result = haystack.substring(left,right+1);
            if (result.equals(needle)) {
                return left;
            }
            if (result.length() == needle.length() && !result.equals(needle)) {
                // 移动左边界
                left++;
            }
            right++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
