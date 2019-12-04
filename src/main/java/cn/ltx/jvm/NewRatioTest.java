package cn.ltx.jvm;

/**
 * Description:设置新生代与老年代比例
 * -Xms20m -Xmx20m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
 * -XX:NewRatio=2 表示1:2
 *
 * @author litianxiang
 */
public class NewRatioTest {
    public static void main(String[] args) {
        Byte[] b = null;
        for (int i = 0; i < 10; i++) {
            b = new Byte[1 * 1024 * 1024];
            System.out.println(b);
        }
    }
}
