
//leetcode submit region begin(Prohibit modification and deletion)
// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    public boolean checkInclusion(String t, String s) {
        //使用哈希表用于记录 t 中每个字符出现的次数
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //初始化窗口的左右边界及合法字符个数
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            //c 是将移入窗口的字符
            char c = s.charAt(right);
            //右移窗口
            right++;
            //进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            //判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                //在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
                //d 是将移出窗口的字符
                char d = s.charAt(left);
                //左移窗口
                left++;

                //进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        //未找到符合条件的子串
        return false;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
