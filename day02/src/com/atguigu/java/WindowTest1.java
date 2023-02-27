package com.atguigu.java;

/**
 * 例子：创建三个窗口买票，总票数为100张
 *
 * @author llystart
 * @create 2022-12-11-9:56
 */
class Window1 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        boolean isFlag = true;
        while (isFlag) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+"卖票:票号为："+ticket--);
            }else{
                isFlag = false;
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);
        t1.setName("窗口1：");
        t2.setName("窗口2：");
        t3.setName("窗口3：");
        t1.start();
        t2.start();
        t3.start();
    }
}
