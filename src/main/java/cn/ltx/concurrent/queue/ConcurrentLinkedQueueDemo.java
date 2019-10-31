package cn.ltx.concurrent.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue();
        //入列,add与offer类似,一般用offer
        queue.add("张三");
        queue.offer("李四");
        queue.add("王五");
        //出列,peek不会删除队列的元素，poll会删除，一般用poll
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }
}
