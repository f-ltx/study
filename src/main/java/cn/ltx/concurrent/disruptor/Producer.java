package cn.ltx.concurrent.disruptor;

import cn.ltx.concurrent.disruptor.event.LongEvent;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

public class Producer {
    private RingBuffer<LongEvent> ringBuffer;

    public Producer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void publish(ByteBuffer byteBuffer) {
        long sequence = ringBuffer.next();
        LongEvent longEvent = ringBuffer.get(sequence);
        try {
            longEvent.setValue(byteBuffer.getLong(0));
        } catch (Exception e) {

        } finally {
            System.out.println("Producer publish - " + longEvent.getValue());
            ringBuffer.publish(sequence);
        }
    }
}
