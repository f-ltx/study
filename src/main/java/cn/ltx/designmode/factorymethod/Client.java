package cn.ltx.designmode.factorymethod;

public class Client {
    public static void main(String[] args) {
        Factory bydFactory = new BydFactory();
        Car byd = bydFactory.createCar("±ÈÑÇµÏ");
        byd.run();

        Factory geelyFactory = new GeelyFactory();
        Car jl = geelyFactory.createCar("¼ªÀû");
        jl.run();
    }
}
