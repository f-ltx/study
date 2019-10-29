package cn.ltx.designmode.factorymethod;

public class GeelyFactory implements Factory {

    @Override
    public Car createCar(String carName) {
        return new GeelyCar(carName);
    }
}
