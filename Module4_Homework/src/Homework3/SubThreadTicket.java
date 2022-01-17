package Homework3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 Thread 方式实现卖票 使用lock
 */
public class SubThreadTicket extends Thread{
    private static int ticket_num = 100; //总共100张票
    private ReentrantLock lock = new ReentrantLock(); //准备一把锁

    @Override
    public void run(){

        System.out.println("线程" + Thread.currentThread().getName() + "已启动");
        while(true){
            lock.lock(); //加锁

            //卖票
            if(ticket_num > 0){
                System.out.println(Thread.currentThread().getName() + "已卖出一张票，还剩" + --ticket_num +"张票。");
                //卖完一张票之后停顿200ms
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("票已全部卖完！");
                break;
            }

            lock.unlock(); //解锁
        }

    }

    //main方法
    public static void main(String[] args) {

        //创建线程对象
        SubThreadTicket stt1 = new SubThreadTicket();
        SubThreadTicket stt2 = new SubThreadTicket();
        SubThreadTicket stt3 = new SubThreadTicket();

        //运行线程
        stt1.start();
        stt2.start();
        stt3.start();
    }
}
