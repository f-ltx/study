package cn.ltx.designmode.abstractfactory;

public interface CarFactory {
    EngineFactory createEngine();
    ChairFactory createChair();
}
