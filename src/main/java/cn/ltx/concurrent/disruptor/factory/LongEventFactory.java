package cn.ltx.concurrent.disruptor.factory;

import cn.ltx.concurrent.disruptor.event.LongEvent;
import com.lmax.disruptor.EventFactory;

public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
