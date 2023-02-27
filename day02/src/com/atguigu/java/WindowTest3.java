package com.atguigu.java;

/**
 * 使用同步方法来解决Runnable接口的线程安全问题
 *
 * @author llystart
 * @create 2022-12-12-10:20
 */
class Window3 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        boolean isFlag = true;
        while (isFlag) {
            show();
            if(ticket<=0){
                isFlag = false;
            }
        }//end while
    }

    private synchronized void show(){//同步监视器：this
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票:票号为：" + ticket--);
        }
    }

}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1：");
        t2.setName("窗口2：");
        t3.setName("窗口3：");
        t1.start();
        t2.start();
        t3.start();
    }
}