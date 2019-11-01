package cn.ltx.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:定长线程池，底层使用ThreadPoolExecutor，然后队列使用LinkedBlockingQueue
 *
 * @author Administrator
 * @date 2019/11/1
 */
public class NewFixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " - " + temp);
                }
            });
        }
    }
}
