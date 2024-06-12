package com.shq.demo.dataStructure.平衡括号字符串的最少插入次数;

public class Solution {

    public int minInsertions(String s) {
        // 需要插入(的次数
        int res = 0;
        // 需要插入)的次数
        int need = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                need = need+2;
            }
            if (s.charAt(i) == ')') {
                need--;
                if (need == -2) {
                    need = 0;
                    res++;
                }
            }
        }
        return res+need;
    }
}
