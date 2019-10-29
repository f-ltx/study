package cn.ltx.designmode.abstractfactory;

public class NatureEngine implements EngineFactory {
    @Override
    public void setup() {
        System.out.println("装配自然吸气");
    }
}
