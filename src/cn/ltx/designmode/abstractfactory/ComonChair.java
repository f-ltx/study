package cn.ltx.designmode.abstractfactory;

public class ComonChair implements ChairFactory {

    @Override
    public void setup() {
        System.out.println("装配普通座椅");
    }
}
