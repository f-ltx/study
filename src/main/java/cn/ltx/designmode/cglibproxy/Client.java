package cn.ltx.designmode.cglibproxy;

public class Client {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        UserDaoImpl target = (UserDaoImpl)cglibProxy.getTarget(new UserDaoImpl());
        target.add();
    }
}
