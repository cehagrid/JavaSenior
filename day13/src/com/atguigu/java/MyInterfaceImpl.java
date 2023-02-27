package com.atguigu.java;

/**
 * @author llystart
 * @create 2023-02-06-20:02
 */
public class MyInterfaceImpl implements MyInterface{

    @Override
    public void methodAbstract() {

    }

    @Override
    public void methodDefault() {
        System.out.println("我是重写的默认方法");;
    }

    public static void main(String[] args) {
        MyInterfaceImpl m1 = new MyInterfaceImpl();
        m1.methodDefault();
    }
}
