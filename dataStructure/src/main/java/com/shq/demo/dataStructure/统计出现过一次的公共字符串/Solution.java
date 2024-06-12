package com.shq.demo.dataStructure.统计出现过一次的公共字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * 给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。
     * @param words1
     * @param words2
     * @return
     */
    public int countWords(String[] words1, String[] words2) {
        int result = 0;
        // 求交集
        Map<String,Integer> words1ToCount = new HashMap<>();
        Map<String,Integer> words2ToCount = new HashMap<>();
        for (String word : words1) {
            words1ToCount.put(word,words1ToCount.getOrDefault(word,0)+1);
        }
        for (String word : words2) {
            words2ToCount.put(word,words2ToCount.getOrDefault(word,0)+1);
        }
        for (String word : words1) {
            if (words1ToCount.containsKey(word)
                    && words2ToCount.containsKey(word)
                    && words1ToCount.get(word).equals(1)
                    && words2ToCount.get(word).equals(1)) {
                result++;
            }
        }
        return result;
    }



}
