package cn.ltx.concurrent.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Description:定时执行线程池，使用ExecutorService的子类接收,使用schedule方法执行
 *
 * @author Administrator
 * @date 2019/11/1
 */
public class NewScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(4);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newScheduledThreadPool.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " - " + temp);
                }
            }, 3, TimeUnit.SECONDS);
        }
    }
}
