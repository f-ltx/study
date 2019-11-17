package cn.ltx.jvm.survivorratio;

//使用示例:-Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
//说明：堆内存初始化值20m,堆内存最大值20m，新生代最大值可用1m，eden空间和from/to空间的比例为2/1
public class SurvivorRatioTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            byte[] b = new byte[1 * 1024 * 1024];
            System.out.println(b);
        }
    }
}
