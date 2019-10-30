package cn.ltx.designmode.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserDaoHandler implements InvocationHandler {
    private Object target;
    public UserDaoHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理-开启事务");
        Object invoke = method.invoke(target, args);
        System.out.println("动态代理-提交事务");
        return invoke;
    }
}
