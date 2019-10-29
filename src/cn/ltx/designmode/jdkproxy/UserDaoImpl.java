package cn.ltx.designmode.jdkproxy;

public class UserDaoImpl implements IUserDao {
    @Override
    public void add() {
        System.out.println("增加用户");
    }
}
