package cn.ltx.designmode.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//1.实现MethodInterceptor接口
public class CglibProxy implements MethodInterceptor {
    private Object target;

    //2.建立代理对象和真实对象的关系，使用enhancer.create
    public Object getTarget(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    //3.覆写intercept方法，methodProxy.invoke(真实对象，参数)
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理-开启事务");
        //invoke第一个参数要使用this.target
        Object invoke = methodProxy.invoke(this.target, objects);
        System.out.println("cglib动态代理-提交事务");
        return invoke;
    }
}
