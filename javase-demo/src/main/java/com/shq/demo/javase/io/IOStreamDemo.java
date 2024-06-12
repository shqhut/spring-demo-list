package com.shq.demo.javase.io;

import java.io.*;

public class IOStreamDemo {

    public static void main(String[] args) {
        writer2();
    }

    public static void fileOutputStream1() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("/Users/wayz/Desktop/io-test/test5.txt");
            // 写出数据，一个字节表示一个二进制序列，转换为十进制，范围是0-255；
            // ASCII码表是将一个字节对应到10进制的0-127，
            fos.write(97); // 写入第一个字节
            fos.write(98); // 写入第二个字节
            fos.write(99); // 写入第三个字节
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void fileOutputStream2() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("/Users/wayz/Desktop/io-test/test6.txt");
            // 字符串转化为字节数组
            byte[] bytes = "我爱你中国".getBytes();
            fos.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void fileOutputStream3() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("/Users/wayz/Desktop/io-test/test7.txt");
            // 字符串转化为字节数组
            byte[] bytes = "abcde".getBytes();
            fos.write(bytes,2, 2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void fileInputStream1() {
        FileInputStream fio = null;
        try {
            fio = new FileInputStream("/Users/wayz/Desktop/io-test/test7.txt");
            // read返回数据的下一个字节，没有数据返回-1
            int nextByte = 0;
            while (nextByte != -1) {
                nextByte = fio.read();
                if (nextByte != -1) {
                    System.out.println((char) nextByte);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fio.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void fileInputStream2() {
        FileInputStream fio = null;
        try {
            fio = new FileInputStream("/Users/wayz/Desktop/io-test/test7.txt");
            int len;
            byte[] bytes = new byte[2];
            while ((len = fio.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fio.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void fileCopy() {
        FileInputStream fio = null;
        FileOutputStream fos = null;
        try {
            fio = new FileInputStream("/Users/wayz/Desktop/io-test/001.pic.jpg");
            fos = new FileOutputStream("/Users/wayz/Desktop/io-test/002.pic.jpg");
            byte[] bytes = new byte[1024];
            while (fio.read(bytes) != -1) {
                fos.write(bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fio.close();
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void reader1() {
        Reader read = null;
        try {
            read = new FileReader("/Users/wayz/Desktop/io-test/test7.txt");
            int len;
            char[] cbuf = new char[2];
            while ((len = read.read(cbuf)) != -1) {
                System.out.println(new String(cbuf, 0, len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                read.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void writer1() {
        Writer writer = null;
        try {
            writer = new FileWriter("/Users/wayz/Desktop/io-test/test7.txt");
            writer.write(99);
            writer.write(100);
            writer.write(100);
            // 此时字符并为写入到文件中，只是写到流中，当writer.close时字符才会写入文件中
            System.out.println("休眠10秒");
            Thread.sleep(10000);
            System.out.println("休眠结束");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void writer2() {
        Writer writer = null;
        try {
            writer = new FileWriter("/Users/wayz/Desktop/io-test/test7.txt");
            writer.write("刷");
            writer.flush();
            writer.write("新");
            System.out.println("休眠10秒");
            Thread.sleep(10000);
            System.out.println("休眠结束");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
