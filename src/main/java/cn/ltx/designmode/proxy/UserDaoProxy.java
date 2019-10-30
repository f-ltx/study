package cn.ltx.designmode.proxy;

public class UserDaoProxy implements IUserDao {
    private IUserDao userDao;
    public UserDaoProxy(IUserDao userDao){
        this.userDao = userDao;
    }
    @Override
    public void add() {
        System.out.println("开启事务");
        userDao.add();
        System.out.println("提交事务");
    }
}
