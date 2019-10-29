package cn.ltx.designmode.factorymethod;

public class BydFactory implements Factory {

    @Override
    public Car createCar(String carName) {
        return new BydCar(carName);
    }
}
