package com.shq.demo.dataStructure.栈.有效的括号;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // 利用栈先进后出的特性，左扩号就入栈，右括号就取栈顶比较
        for (Character c : s.toCharArray()) {
            if (c.equals('(') || c.equals('{') || c.equals('[')) {
                stack.push(c);
            }else {
                if (!stack.isEmpty() && leftCon(c).equals(stack.peek())){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public Character leftCon(Character rightCon) {
        if (rightCon.equals(')')) {
            return '(';
        } else if (rightCon.equals('}')) {
            return '{';
        } else {
            return '[';
        }
    }
}