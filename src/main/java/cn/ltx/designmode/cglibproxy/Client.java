package cn.ltx.designmode.cglibproxy;

public class Client {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        //4.使用代理类的getTarget方法，获取代理对象
        UserDaoImpl target = (UserDaoImpl) cglibProxy.getTarget(new UserDaoImpl());
        target.add();
    }
}
