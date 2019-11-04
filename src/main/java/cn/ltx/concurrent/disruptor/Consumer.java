package cn.ltx.concurrent.disruptor;

import cn.ltx.concurrent.disruptor.event.LongEvent;
import com.lmax.disruptor.EventHandler;

public class Consumer implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("Consumer get data - " + longEvent.getValue());
    }
}
