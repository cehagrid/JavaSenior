package com.atguigu.java;

/**
 *
 * 例子：创建三个窗口买票，总票数为100张
 * 存在线程安全问题，待解决。。。
 *
 * @author llystart
 * @create 2022-12-10-21:50
 */
class Window extends Thread{


    private static int ticket = 100;

    @Override
    public void run() {
        boolean isFlag = true;
        while(isFlag){

            if (ticket > 0) {
                System.out.println(getName()+"买票，票号为："+ticket--);
            }else{
                break;
            }
        }
    }
}



public class WindowTest {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1：");
        t2.setName("窗口2：");
        t3.setName("窗口3：");
        t1.start();
        t2.start();
        t3.start();
    }
}
