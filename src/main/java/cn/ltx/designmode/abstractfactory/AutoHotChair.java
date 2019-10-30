package cn.ltx.designmode.abstractfactory;

public class AutoHotChair implements ChairFactory {
    @Override
    public void setup() {
        System.out.println("装配自动加热");
    }
}
