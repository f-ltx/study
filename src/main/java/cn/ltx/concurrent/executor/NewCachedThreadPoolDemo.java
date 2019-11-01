package cn.ltx.concurrent.executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:可缓存的线程池，重复利用
 *
 * @author Administrator
 * @date 2019/11/1
 */
public class NewCachedThreadPoolDemo {
    public static void main(String[] args) {
        //核心是利用ThreadPoolExecutor，最大线程数无限大小，主要参数（核心线程数，最大线程数）
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            //不用start，自动执行线程
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " - "+ temp);
                }
            });
        }
    }
}
