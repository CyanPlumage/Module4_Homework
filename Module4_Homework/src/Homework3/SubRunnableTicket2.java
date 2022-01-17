package Homework3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 Rnnable方式实现卖票 使用lock
 */
public class SubRunnableTicket2 implements Runnable{

    private static int ticket_num = 100; //总共100张票
    private ReentrantLock lock = new ReentrantLock(); //准备一把锁

    @Override
    public void run() {
        System.out.println("线程" + Thread.currentThread().getName() + "已启动");


        while(true){
            lock.lock(); //加锁
            //卖票
            //synchronized (this){
                if(ticket_num > 0){

                    System.out.println(Thread.currentThread().getName() + "已卖出一张票，还剩" + --ticket_num +"张票。");

                    //卖完一张票之后停顿200ms
                    try {
                        //System.out.println("1");
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("票已全部卖完！");
                    lock.unlock(); //解锁
                    break;
                }
            //}
            lock.unlock(); //解锁
        }
        System.out.println("线程" + Thread.currentThread().getName() + "已结束。");
    }

    //main方法
    public static void main(String[] args) {
        //创建实现Runnable接口的SubRunnableTicket类型对象
        SubRunnableTicket2 srt2 = new SubRunnableTicket2();

        //使用该对象作为实参构造Thread类型对象
        Thread t1 = new Thread(srt2);
        Thread t2 = new Thread(srt2);
        Thread t3 = new Thread(srt2);

        //使用Thread类对象调用start方法
        t1.start();
        t2.start();
        t3.start();

        System.out.println("已到底部！");
    }
}

