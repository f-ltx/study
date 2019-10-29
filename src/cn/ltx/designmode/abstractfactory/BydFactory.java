package cn.ltx.designmode.abstractfactory;

public class BydFactory implements CarFactory {
    @Override
    public EngineFactory createEngine() {
        return new TurboEngine();
    }

    @Override
    public ChairFactory createChair() {
        return new AutoHotChair();
    }
}
