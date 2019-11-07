package cn.ltx.designmode.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Decorator decorator = new Decorator(component);
        decorator.run();
    }
}

interface Component {
    void run();
}

class ConcreteComponent implements Component {

    @Override
    public void run() {
        System.out.println("具体子类的方法");
    }
}

class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void run() {
        System.out.println("装饰。。。。");
        this.component.run();
    }
}
