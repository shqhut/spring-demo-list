package com.shq.demo.javase.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/wayz/Desktop/io-test/test.txt");

        System.out.println("文件路经" + file.getAbsoluteFile());

        System.out.println("文件名称" + file.getName());

        System.out.println("文件大小：" + file.length() + "字节");

        File dir = new File("/Users/wayz/Desktop/io-test");

        if (!dir.isFile()) {
            File[] files = dir.listFiles();
            for (File ele : files) {
                System.out.println(ele.getAbsolutePath());
            }
        }

        // 创建文件
        File file2 = new File("/Users/wayz/Desktop/io-test/test4.txt");
        if (!file2.exists()) {
            boolean newFile = file2.createNewFile();
            System.out.println("创建文件结果：" + newFile);
        }
        System.out.println("是否是文件：" + file2.isFile());

    }

}
