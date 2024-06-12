package com.shq.demo.dataStructure.栈.逆波兰表达式求值;

import java.util.Stack;

public class Solution {

    public int evalRPN(String[] tokens) {
        // 适合用栈操作运算：遇到数字则入栈；
        // 遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (!checkSign(s)) {
                stack.push(Integer.valueOf(s));
            }else {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(operation(a,b,s));
            }
        }
        return stack.pop();
    }

    public boolean checkSign(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public int operation(int a,int b,String opt) {
        if (opt.equals("+")) {
            return a + b;
        } else if (opt.equals("-")) {
            return a - b;
        } else if (opt.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }
}
