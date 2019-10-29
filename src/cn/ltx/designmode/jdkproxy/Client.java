package cn.ltx.designmode.jdkproxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        IUserDao userDao = new UserDaoImpl();
        UserDaoHandler userDaoHandler = new UserDaoHandler(userDao);
        ClassLoader classLoader = userDao.getClass().getClassLoader();
        Class<?>[] interfaces = userDao.getClass().getInterfaces();
        IUserDao instance = (IUserDao)Proxy.newProxyInstance(classLoader, interfaces, userDaoHandler);
        instance.add();
    }
}
