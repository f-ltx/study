package cn.ltx.jvm;

/**
 * Description:栈溢出
 * 1.只会在递归调用中，报java.lang.StackOverflowError
 * 2.可以加大或减少递归深度-Xss5m
 *
 * @author litianxiang
 * @date 2019-11-22
 */
public class StackOverFlowErrorTest {
    private static int count;

    public static void count() {
        try {
            count++;
            count();
        } catch (Throwable e) {
            System.out.println("最大深度:" + count);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        count();
    }

}
