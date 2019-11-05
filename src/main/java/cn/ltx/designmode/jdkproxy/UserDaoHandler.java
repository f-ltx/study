package cn.ltx.designmode.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description:jdk动态代理
 *
 * @author litianxiang
 * @date 2019-11-05
 */
//1.实现InvocationHandler接口
public class UserDaoHandler implements InvocationHandler {
    private Object target;

    //2.建立代理对象和真实对象的关系
    public UserDaoHandler(Object target) {
        this.target = target;
    }

    //3.重写invoke方法，method.invoke(真实对象,参数)
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理-开启事务");
        Object invoke = method.invoke(target, args);
        System.out.println("动态代理-提交事务");
        return invoke;
    }
}
