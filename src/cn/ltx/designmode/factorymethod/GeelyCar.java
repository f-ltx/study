package cn.ltx.designmode.factorymethod;

public class GeelyCar implements Car {
    private String name;

    public GeelyCar(String carName) {
        this.name = carName;
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
