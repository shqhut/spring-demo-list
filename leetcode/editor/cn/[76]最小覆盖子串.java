// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    public String minWindow(String s, String t) {
        // 索引开始位置
        int start = 0;
        // 覆盖子串长度
        int len = Integer.MAX_VALUE;
        // 覆盖字符数量
        int vaild = 0;
        // 定义滑动窗口边界
        int right = 0;
        int left = 0;
        // 覆盖字串，不近要包含字串，且字串中每个字符的数量也要足够
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> windows = new HashMap<>();
        for (char c:t.toCharArray()) {
            need.put(c,need.getOrDefault(c, 0)+1);
        }

        while (right<s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c,0)+1);
                if (windows.get(c).equals(need.get(c))) {
                    vaild++;
                }
            }
            // 提前++，计算长度的时候就不用再+1了
            right++;
            // result满足条件
            while (vaild == need.size()) {
                // 更新最优结果
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 窗口缩小
                // 要移除的元素
                char remove = s.charAt(left);
                left++;
                // 窗口移除remove后，结果是否要变动
                if (need.containsKey(remove)) {
                    if (windows.get(remove).equals(need.get(remove))) {
                        vaild--;
                    }
                    windows.put(remove, windows.getOrDefault(remove,0)-1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}
