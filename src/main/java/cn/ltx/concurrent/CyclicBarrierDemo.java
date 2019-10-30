package cn.ltx.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * Description:当所有线程都走到内存屏障处，才继续往下走。
 * 当所有线程的操作都执行完了，才执行“结束执行语句”
 *
 * @author Administrator
 * @date 2019/10/30
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new CyclicBarrierDemoThread(cyclicBarrier)).start();
        }
    }
}

class CyclicBarrierDemoThread implements Runnable {
    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierDemoThread(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始执行...");
        try {
            System.out.println("模拟耗时操作");
            Thread.sleep(300);
            this.cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束执行...");
    }
}