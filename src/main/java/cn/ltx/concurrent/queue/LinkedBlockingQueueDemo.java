package cn.ltx.concurrent.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LinkedBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        //初始化值，则为有界，没有初始化，则为无界
        BlockingQueue<String> queue = new LinkedBlockingQueue();
        Producer producer = new Producer(queue);
        new Thread(producer).start();
        new Thread(new Consumer(queue)).start();
        Thread.sleep(10000);
        producer.stop();
    }
}

class Producer implements Runnable {
    private BlockingQueue<String> blockingQueue;
    private volatile boolean flag = true;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            AtomicInteger i = new AtomicInteger();
            while (flag) {
                this.blockingQueue.offer("producer - " + i.incrementAndGet(), 2, TimeUnit.SECONDS);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("producer failed");
        }
    }

    public void stop() {
        this.flag = false;
        System.out.println("producer stop");
    }
}

class Consumer implements Runnable {
    private BlockingQueue<String> blockingQueue;
    private volatile boolean flag = true;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (flag) {
                String poll = this.blockingQueue.poll(2, TimeUnit.SECONDS);
                System.out.println("consumer - " + poll);
                if (poll == null) {
                    this.flag = false;
                    System.out.println("consumer stop");
                    return;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("consumer failed");
        }
    }
}