package cn.ltx.designmode.singleton;

/**
 * Description:
 *
 * @author litianxiang
 * @date   2019-10-29
 */
public class Singleton {
    private volatile static Singleton INSTANCE;

    private Singleton() {
        if (INSTANCE != null) {
            throw new RuntimeException("haha");
        }
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
