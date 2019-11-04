package cn.ltx.concurrent.util;

import java.util.concurrent.CountDownLatch;

/**
 * Description:倒计
 *
 * @author Administrator
 * @date 2019/10/30
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread t1 = new Thread(new CountDownLatchDemoThread(countDownLatch));
        Thread t2 = new Thread(new CountDownLatchDemoThread(countDownLatch));
        Thread t3 = new Thread(new CountDownLatchDemoThread(countDownLatch));
        t1.start();
        t2.start();
        t3.start();
        //倒数等待，只有CountDownLatch的值为0，后面的才继续
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName());
    }
}
class CountDownLatchDemoThread implements Runnable{
    private CountDownLatch countDownLatch;

    public CountDownLatchDemoThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        //倒数减一
        this.countDownLatch.countDown();
    }
}
