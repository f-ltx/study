package cn.ltx.concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        //最大存3个
        BlockingQueue<String> queue = new ArrayBlockingQueue(3);
        //入列
        queue.offer("张三");
        boolean b1 = queue.offer("李四", 3, TimeUnit.SECONDS);
        //b1为true，队列有位置，不用等待，直接存
        System.out.println(b1);
        queue.offer("王五");
        boolean b2 = queue.offer("赵六", 3, TimeUnit.SECONDS);
        //b2为false，队列没有位置，等待3秒，没有出列就会存失败
        System.out.println(b2);

        //出列
        //张三
        System.out.println(queue.poll());
        //李四，不会等待
        System.out.println(queue.poll(3, TimeUnit.SECONDS));
        //王五，不会等待
        System.out.println(queue.poll(3, TimeUnit.SECONDS));
        //等待,null
        System.out.println(queue.poll(3, TimeUnit.SECONDS));
    }
}
