package cn.ltx.concurrent.executor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description:直接创建线程池
 *
 * @author Administrator
 * @date 2019/11/1
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3));
        //1.进入线程池
        threadPoolExecutor.execute(new ThreadTest());
        //2.大于核心线程数，进入队列。队列有1
        threadPoolExecutor.execute(new ThreadTest());
        //3.大于核心线程数，进入队列。队列有2
        threadPoolExecutor.execute(new ThreadTest());
        //4.大于核心线程数，进入队列。队列有3
        threadPoolExecutor.execute(new ThreadTest());
        //5.大于核心线程数，队列满。判断最大线程数，还可以创建
        threadPoolExecutor.execute(new ThreadTest());
        //6.队列满，最大线程数也超了，报错
//        threadPoolExecutor.execute(new ThreadTest());
        threadPoolExecutor.shutdown();
    }
}

class ThreadTest implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}