package cn.ltx.concurrent.disruptor.event;

public class LongEvent {
    private Long value;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
