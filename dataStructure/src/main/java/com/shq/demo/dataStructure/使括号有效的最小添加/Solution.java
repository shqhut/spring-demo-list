package com.shq.demo.dataStructure.使括号有效的最小添加;

public class Solution {

    /**
     * case1:))( 需要插入3次
     * @param s
     * @return
     */
    public int minAddToMakeValid(String s) {
        // )一定要插到(后，是有先后顺序的
        int res = 0;
        // 需要)的数量
        int need = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                need++;
            }
            // 精髓在于判断括号的先后顺序
            if (s.charAt(i) == ')') {
                need--;
                if (need == -1) {
                    need = 0;
                    res++;
                }
            }
        }
        return res + need;
    }
}
