package com.atguigu.exer;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author llystart
 * @create 2023-01-26-17:45
 */
public class PicTest {

    /*
    图片的加密
     */
    @Test
    public void test() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
//        FileInputStream fis = new FileInputStream(new File("day.jpg"));
            fis = new FileInputStream("day.jpg");
            fos = new FileOutputStream("daySERCET.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                //字节数据进行修改
                //错误的
                //            for (byte b : buffer) {
                //                b = (byte) (b ^ 5);
                //            }
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                    //                buffer[i] ^= 5;
                }
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
    /*
    图片的解密
     */
    @Test
    public void test2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
//        FileInputStream fis = new FileInputStream(new File("day.jpg"));
            fis = new FileInputStream("daySERCET.jpg");
            fos = new FileOutputStream("day4.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                //字节数据进行修改
                //错误的
                //            for (byte b : buffer) {
                //                b = (byte) (b ^ 5);
                //            }
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                    //                buffer[i] ^= 5;
                }
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    /*
    练习：统计字符出现的次数，tips：用Hap
     */
    @Test
    public void mtest(){
        FileReader fr = null;
        BufferedWriter bw = null;
        try {
            //1.创建集合Map
            Map<Character,Integer> map = new HashMap<>();
            //2.遍历每一个字符，每一个字符出现的次数放到map中
            fr = new FileReader("dbcp.txt");
            int c = 0;
            while ((c = fr.read()) != -1){
                //int还原为char
                char ch = (char) c;
                //判断char是否在map中第一次出现
                if(map.get(ch) == null){
                    map.put(ch,1);
                }else{
                    map.put(ch,map.get(ch) + 1);
                }
            }

            //3.把map中的数据存在文件count.txt
            //3.1 创建Writer
            bw = new BufferedWriter(new FileWriter("wordcount.txt"));

            //遍历map,在写数据
            Set<Map.Entry<Character,Integer>> entryset = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entryset) {
                switch (entry.getKey()){
                    case ' ':
                        bw.write("空格="+entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab键="+entry.getValue());
                        break;
                    case '\r':
                        bw.write("Enter="+entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行="+entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey()+"="+entry.getValue());
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
