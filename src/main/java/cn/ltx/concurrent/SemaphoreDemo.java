package cn.ltx.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Description:信号量
 *
 * @author Administrator
 * @date 2019/10/30
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(new SemaphoreDemoThread(semaphore)).start();
        }
    }
}

class SemaphoreDemoThread implements Runnable {
    private Semaphore semaphore;

    public SemaphoreDemoThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        //查看当前信号量
        int i = semaphore.availablePermits();
        if (i > 0) {
            System.out.println(Thread.currentThread().getName() + "有坑，爽");
        } else {
            System.out.println(Thread.currentThread().getName() + "没坑，等吧");
        }
        try {
            //申请资源
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "上坑");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "上坑完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            semaphore.release();
        }
    }
}
