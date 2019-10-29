package cn.ltx.designmode.singleton;

/**
 * Description:µ¥ÀýÄ£Ê½IoDH
 *
 * @author litianxiang
 * @date 2019-10-29
 */
public class SingletonIoDH {
    private SingletonIoDH(){}
    private static class Handler{
        private static final SingletonIoDH INSTANCE = new SingletonIoDH();
    }
    public static SingletonIoDH getInstance(){
        return Handler.INSTANCE;
    }
}
