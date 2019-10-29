package cn.ltx.designmode.abstractfactory;

public class Client {
    public static void main(String[] args) {
        BydFactory bydFactory = new BydFactory();
        EngineFactory engine = bydFactory.createEngine();
        ChairFactory chair = bydFactory.createChair();
        engine.setup();
        chair.setup();
    }
}
