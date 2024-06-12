
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String resutl = "";
        for (int i = 0; i < s.length() ; i++) {
            String s1 = palindrome(s,i,i);
            String s2 = palindrome(s,i,i+1);
            resutl = resutl.length() > s1.length() ? resutl : s1;
            resutl = resutl.length() > s2.length() ? resutl : s2;
        }
        return resutl;
    }

    public String palindrome(String s,int left, int right) {
        // 通过下标操作数组要注意防止下标越界
        while (left >= 0 && right <= s.length()-1
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
