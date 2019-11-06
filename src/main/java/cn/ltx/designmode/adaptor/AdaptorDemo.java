package cn.ltx.designmode.adaptor;

public class AdaptorDemo {
    public static void main(String[] args) {
        Power220V power220V = new Power220VImpl();
        PowerAdaptor powerAdaptor = new PowerAdaptor(power220V);
        ElectricCooker110V cooker110V = new ElectricCooker110V(powerAdaptor);
        cooker110V.cook();
    }
}

class PowerAdaptor implements Power110V {
    private Power220V power220V;

    public PowerAdaptor(Power220V power220V) {
        this.power220V = power220V;
    }

    @Override
    public void work() {
        this.power220V.work();
    }
}

class ElectricCooker110V {

    private Power110V power110V;

    public ElectricCooker110V(Power110V power110V) {
        this.power110V = power110V;
    }

    public void cook() {
        this.power110V.work();
    }
}

interface Power220V {
    void work();
}

class Power220VImpl implements Power220V {

    @Override
    public void work() {
        System.out.println("220V work...");
    }
}

interface Power110V {
    void work();
}

class Power110VImpl implements Power110V {

    @Override
    public void work() {
        System.out.println("110V work...");
    }
}