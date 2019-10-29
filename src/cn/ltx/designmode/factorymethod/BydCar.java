package cn.ltx.designmode.factorymethod;

public class BydCar implements Car {
    private String name;

    public BydCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name);
    }
}
