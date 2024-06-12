package com.shq.demo.javase.io;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String code;

    private int age;

    private String address;

    public Employee(String name, String code, int age) {
        this.name = name;
        this.code = code;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", age=" + age +
                '}';
    }
}
