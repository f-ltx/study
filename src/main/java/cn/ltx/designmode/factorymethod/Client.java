package cn.ltx.designmode.factorymethod;

public class Client {
    public static void main(String[] args) {
        Factory bydFactory = new BydFactory();
        Car byd = bydFactory.createCar("比亚迪");
        byd.run();

        Factory geelyFactory = new GeelyFactory();
        Car jl = geelyFactory.createCar("吉利");
        jl.run();
    }
}
