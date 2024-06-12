package com.shq.demo.javase.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecimalDemo {

    public static void main(String[] args) {
        Double d = 0.0163;
        BigDecimal num1 = new BigDecimal(d);
        BigDecimal num2 = new BigDecimal("0.0163");
        System.out.println(num2);
        BigDecimal num3 = new BigDecimal("0");
        System.out.println(num2.equals(BigDecimal.ZERO));
        int flag = num3.compareTo(BigDecimal.ZERO);
        System.out.println(flag);
        BigDecimal num4 = new BigDecimal("333.98").setScale(0, RoundingMode.HALF_UP);
        int i = num4.intValue();
        System.out.println(i);
    }

}
