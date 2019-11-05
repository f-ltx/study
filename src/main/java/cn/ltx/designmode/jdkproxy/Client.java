package cn.ltx.designmode.jdkproxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        IUserDao userDao = new UserDaoImpl();
        UserDaoHandler userDaoHandler = new UserDaoHandler(userDao);
        ClassLoader classLoader = userDao.getClass().getClassLoader();
        Class<?>[] interfaces = userDao.getClass().getInterfaces();
        //4.使用Proxy.newProxyInstance生成代理对象
        IUserDao instance = (IUserDao)Proxy.newProxyInstance(classLoader, interfaces, userDaoHandler);
        instance.add();
    }
}
