package com.shq.demo.dataStructure.数组链表;

import java.util.HashMap;
import java.util.Map;

public class 滑动窗口 {

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

    /**
     * [567]字串的排列
     */
    public boolean checkInclusion(String s1, String s2) {
        // s1不固定，个数固定且字符要连续，说明窗口可以固定大小
        // 顺序没要求说明每个字符包含的数量一样即可
        Map<Character,Integer> need = new HashMap<>();
        for (char c : s2.toCharArray()) {
            need.put(c,need.getOrDefault(c, 0)+1);
        }
        int left = 0;
        int right = s1.length()-1;
        while (right < s2.length()) {
            int cursor = left;
            Map<Character,Integer> windows = new HashMap<>();
            int vaild = 0;  // 匹配到的字符种类数量
            while (cursor <= right) {
                char c = s2.charAt(cursor);
                if (!need.containsKey(c)) {
                    break;
                }else {
                    windows.put(c, windows.getOrDefault(c,0)+1);
                    if (windows.get(c).equals(need.get(c))) {
                        vaild++;
                    }
                }
                cursor++;
            }
            if (vaild == need.size()) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }

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


    public static void main(String[] args) {
        // baca
        String s = "acbbaca", t = "aba";
        滑动窗口 a = new 滑动窗口();
        String s1 = a.minWindow(s, t);
        System.out.println(s1);
    }

}
