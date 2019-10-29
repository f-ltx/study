package cn.ltx.designmode.singleton;

/**
 * Description:枚举单例，利用枚举的instance只有一次，构造只实例化一次
 *
 * @author litianxiang
 * @date   2019-10-29
 */
public class UserSingleton {
    private UserSingleton() {
    }

    public static UserSingleton getInstance() {
        return UserEnum.INSTANCE.user;
    }

    private enum UserEnum {
        INSTANCE;
        private UserSingleton user;
        UserEnum(){
            this.user = new UserSingleton();
        }

    }

    public static void main(String[] args) {
        UserSingleton u1 = UserSingleton.getInstance();
        UserSingleton u2 = UserSingleton.getInstance();
        System.out.println(u1 == u2);
    }
}
