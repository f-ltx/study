package cn.ltx.concurrent.disruptor;

import cn.ltx.concurrent.disruptor.event.LongEvent;
import cn.ltx.concurrent.disruptor.factory.LongEventFactory;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DisruptorDemo {
    public static void main(String[] args) {
        //1.可缓存的线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        //2.Event工厂
        EventFactory<LongEvent> eventFactory = new LongEventFactory();
        //3.ringBuffer大小
        int ringBufferSize = 1024;
        //4.创建Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory, ringBufferSize, executor, ProducerType.MULTI, new YieldingWaitStrategy());
        //5.注册消费者，多个消费者重复获取值，如果均摊需要配置
        disruptor.handleEventsWith(new Consumer());
        disruptor.handleEventsWith(new Consumer());
        //6.启动
        disruptor.start();
        //7.获取Ringbuffer容器，生产者发布数据用
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        //8.创建生产者
        Producer producer = new Producer(ringBuffer);
        //9.指定缓冲区大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (int i = 0; i < 100; i++) {
            byteBuffer.putLong(0, i);
            producer.publish(byteBuffer);
        }
        executor.shutdown();
        disruptor.shutdown();
    }
}
