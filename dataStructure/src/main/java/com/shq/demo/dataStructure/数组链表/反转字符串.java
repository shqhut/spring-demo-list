package com.shq.demo.dataStructure.数组链表;

public class 反转字符串 {

    public void reverseString(char[] s) {
        // 左右指针
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            if (s[left] != s[right]) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
            }
            left++;
            right--;
        }
    }

    public String longestPalindrome(String s) {
        // b a b a b
        // b ba bab baba babad  => bab
        // a ab aba abab => aba
        // b ba bab => bab
        // a ab
        int vaild = 0;
        String resutl = "";
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length() ; i++) {
            for (int j = i; j < s.length(); j++) {
                // j => [i,s.length-1]
                int length = j-i+1;
                char[] chars = new char[length];
                System.arraycopy(charArray, i, chars, 0, length);
                // 判断是否为回文子串
                if (checkReverse(chars)) {
                    // 更新最优解
                    if (chars.length > vaild) {
                        resutl = new String(chars);
                        vaild = chars.length;
                    }
                }
            }
        }
        return resutl;
    }

    private boolean checkReverse(char[] chars) {
        // 双指针判断
        int left = 0;
        int right = chars.length-1;
        while (left <= right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String longestPalindrome2(String s) {
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
        if (left > 0 && right < s.length()-1
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left-1,right);
    }

    public static void main(String[] args) {
        String s = "a";
        反转字符串 x = new 反转字符串();
//        x.reverseString(s.toCharArray());
        x.longestPalindrome(s);
    }
}
