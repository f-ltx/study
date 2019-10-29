package cn.ltx.designmode.singleton;

import java.lang.reflect.Constructor;

public class SingletonTest {
    public static void main(String[] args) throws Exception {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);

        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton instance = constructor.newInstance();
        System.out.println(instance);
    }

}
