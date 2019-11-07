package cn.ltx.designmode.observe;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Observe observe = new ConcreteObserve();
        observe.add(new RealSubject("张三"));
        observe.add(new RealSubject("李四"));
        observe.add(new RealSubject("王五"));
        observe.changeState("新的状态1");
        observe.notifyEveryone();
        observe.changeState("新的状态2");
        observe.notifyEveryone();
    }
}

interface Observe {
    void add(Subject subject);

    void remove(Subject subject);

    void notifyEveryone();

    void changeState(String state);
}

class ConcreteObserve implements Observe {
    private List<Subject> list = new ArrayList<>();
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void add(Subject subject) {
        list.add(subject);
    }

    @Override
    public void remove(Subject subject) {
        list.remove(subject);
    }

    @Override
    public void notifyEveryone() {
        for (Subject subject : list) {
            subject.update(this.getState());
        }
    }

    @Override
    public void changeState(String state) {
        this.state = state;
    }
}

interface Subject {
    void update(String state);
}

class RealSubject implements Subject {
    private String name;

    public RealSubject(String name) {
        this.name = name;
    }

    @Override
    public void update(String state) {
        System.out.println(this.name + "得到了消息 - " + state);
    }
}