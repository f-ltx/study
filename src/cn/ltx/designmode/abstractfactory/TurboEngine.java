package cn.ltx.designmode.abstractfactory;

public class TurboEngine implements EngineFactory {
    @Override
    public void setup() {
        System.out.println("装配涡轮增压");
    }
}
