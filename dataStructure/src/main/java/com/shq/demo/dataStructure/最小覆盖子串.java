package com.shq.demo.dataStructure;

public class 最小覆盖子串 {

    public String minWindow(String s, String t) {
        // 最优结果
        String bestResult = "";
        // 当前结果
        String result = "";
        // 滑动窗口
        int left = 0;
        int right = 0;
        int vaild = 0;
        char[] charArray = s.toCharArray();
        while (right < s.length()) {
            // 窗口扩大，加入right对应元素，更新当前result
            result = result + charArray[right];
            if (t.indexOf(charArray[right]) >= 0) {
                vaild++;
            }
            // result满足要求
            while (checkResult(result,t,vaild)) {
                // 更新最优结果bestResult
                if (bestResult.isEmpty() || result.length() < bestResult.length()) {
                    bestResult = result;
                }
                // 窗口缩小，移除left对应元素，left右移
                // 更新result
                char temp = result.toCharArray()[0];
                if (t.indexOf(temp) >= 0) {
                    vaild--;
                }
                left++;
                result = s.substring(left,right+1);
            }
            right++;
        }
        return bestResult;
    }

    private boolean checkResult(String result, String target, int vaild) {
        boolean flag = true;
        // result的长度长于target
        if (vaild < target.length()) {
            flag = false;
        }
        for (char c : target.toCharArray()) {
            int i = result.indexOf(c);
            if (i < 0) {
                flag = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        // baca
        String s = "acbbaca", t = "aba";
        最小覆盖子串 a = new 最小覆盖子串();
        String s1 = a.minWindow(s, t);
        System.out.println(s1);
    }

}
