package cn.ltx.designmode.singleton;

import java.lang.reflect.Constructor;

public class SingletonEnumTest {


    public static void main(String[] args) throws Exception {
        SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        SingletonEnum singletonEnum2 = SingletonEnum.INSTANCE;
        System.out.println(singletonEnum1);
        System.out.println(singletonEnum2);
        Constructor<SingletonEnum> constructor = SingletonEnum.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonEnum singletonEnum = constructor.newInstance();
        System.out.println(singletonEnum);
    }
}
