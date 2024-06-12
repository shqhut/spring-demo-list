package com.shq.demo.javase.io;

import java.io.*;

public class ObjectSerialDemo {

    public static void main(String[] args) {
//        wirteObject();
        readObject();
    }

    public static void wirteObject() {
        Employee emp = new Employee("哈登", "001", 34);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("employee.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(emp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert oos != null;
                oos.close();
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void readObject() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("employee.txt");
            ois = new ObjectInputStream(fis);
            Employee employee = (Employee) ois.readObject();
            System.out.println("姓名：" + employee.getName() + "编码：" + employee.getCode());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fis.close();
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
