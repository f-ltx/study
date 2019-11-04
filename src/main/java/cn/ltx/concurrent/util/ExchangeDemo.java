package cn.ltx.concurrent.util;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangeDemo {
    static Exchanger<String> exchanger = new Exchanger();

    public static void main(String[] args) {
        ExecutorService tp = Executors.newFixedThreadPool(2);
        tp.execute(new Runnable() {
            @Override
            public void run() {
                String a = "stringA";
                try {
                    String exchange = exchanger.exchange(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        tp.execute(new Runnable() {
            @Override
            public void run() {
                String b = "stringB";
                try {
                    //exchanger.exchange(b) = 第一个线程中的值
                    String value = exchanger.exchange(b);
                    System.out.println(value);
                    System.out.println(b.equals(value));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        tp.shutdown();
    }
}