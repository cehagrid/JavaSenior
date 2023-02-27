package com.atguigu.java;

/**
 *
 * 创建多线程的方式二：实现Runnable接口
 * 1. 创建一个实现Runnable接口的类
 * 2. 实现类去实现Runnable中的抽象方法：run()
 * 3. 创建实现类的对象
 * 4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5. 通过Thread类的对象调用start()
 *
 *
 * 比较创建线程的两种方式。
 * 开发中：优先选择：实现Runnable接口的方式
 * 原因：1. 实现的方式没有类的单继承性的局限性
 *      2. 实现的方式更适合处理多个线程有共享数据的情况。
 *
 * 联系：public class Thread implements Runnable
 * 相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中。
 *
 * @author llystart
 * @create 2022-12-11-9:03
 */
//1. 创建一个实现Runnable接口的类
class Mthread /*extends Thread*/ implements Runnable {
//2. 实现类去实现Runnable中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : i = " + i);
            }
        }
    }
}


public class ThreadTest1 {
    public static void main(String[] args) {
//        3. 创建实现类的对象
        Mthread m1 = new Mthread();
//        4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(m1);
        t1.setName("线程1");
//        5. 通过Thread类的对象调用start()：① 调用当前线程的run()-->调用了Runnable类型的target的run()
        t1.start();

        //在启动一个线程：遍历100以内的偶数
        Thread t2 = new Thread(m1);
        t2.setName("线程2");
        t2.start();
    }
}
