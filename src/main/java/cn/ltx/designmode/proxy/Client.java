package cn.ltx.designmode.proxy;

public class Client {
    public static void main(String[] args) {
        IUserDao userDao = new UserDaoImpl();
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.add();
    }
}
