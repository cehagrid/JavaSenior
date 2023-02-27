package com.atguigu.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

/**
 * @author llystart
 * @create 2023-02-06-20:09
 */
public class java9Test {
    //java 9特性5：钻石操作符的升级
    @Test
    public void test1() {
        //钻石操作符与匿名内部类在java 8中不能共存。在java 9中可以。
        Comparator<Object> com = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
    }

    //java9特性六：try操作的升级
    public static void main(String[] args) {
        //java 8之前的资源关闭操作
//        InputStreamReader reader = null;
//        try {
//            reader = new InputStreamReader(System.in);
//            char[] cbuf = new char[20];
//            int len;
//            if((len = reader.read(cbuf)) != -1){
//                String str = new String(cbuf,0,len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        //java 8 的资源关闭操作:资源自动关闭
        //要求自动关闭的资源的实例化必须放在try的一对小括号中
//        try (InputStreamReader reader = new InputStreamReader(System.in)) {
//            char[] cbuf = new char[20];
//            int len;
//            if ((len = reader.read(cbuf)) != -1) {
//                String str = new String(cbuf, 0, len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //java 9 中资源关闭操作,需要自动关闭的资源的实例化可以放在try的一对小括号外
        //此时的资源属性是常量，声明为final的，不可修改
        InputStreamReader reader = new InputStreamReader(System.in);
        try (reader) {
            char[] cbuf = new char[20];
            int len;
            if ((len = reader.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
