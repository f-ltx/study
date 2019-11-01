package cn.ltx.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:单个线程的线程池，相当于单线程，核心线程数为1，最大线程数也是1
 * 
 * @author Administrator
 * @date 2019/11/1
 */
public class NewSingleThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newSingleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " - " + temp);
                }
            });
        }
        //停掉线程池
        newSingleThreadExecutor.shutdown();
    }
}
