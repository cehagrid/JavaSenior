package com.atguigu.java;

/**
 * 使用同步方法处理继承Thread类的方式中的线程安全问题
 *
 * 关于同步方法的总结：
 * 1. 同步方法仍然需要涉及同步监视器，只是不需要我们显示的声明。
 * 2. 非静态的同步方法，同步监视器是：this
 *    静态的同步方法，同步监视器是当前类本身。
 * @author llystart
 * @create 2022-12-12-10:30
 */
class Window4 extends Thread {


    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        boolean isFlag = true;
        while (isFlag) {
            show();
            if (ticket <= 0) {
                break;
            }
        }

    }

    private static synchronized void show() {//同步监视器：Window4.class
        //private synchronized void show() {同步监视器：t1，t2，t3.此种解决方式是错误的
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "买票，票号为：" + ticket--);
        }
    }
}


public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口1：");
        t2.setName("窗口2：");
        t3.setName("窗口3：");
        t1.start();
        t2.start();
        t3.start();
    }
}
