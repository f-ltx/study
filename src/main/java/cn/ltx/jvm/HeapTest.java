package cn.ltx.jvm;

/**
 * Description:堆内存大小配置
 * //使用示例:  -Xmx20m -Xms5m
 * //说明： 当下Java应用最大可用内存为20M， 初始内存为5M
 * @author litianxiang
 */
public class HeapTest {
    public static void main(String[] args) {
        //最大内存
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
        //可用内存
        System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
        //已用内存
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
        byte[] b = new byte[4 * 1024 * 1024];
        System.out.println("分配了4M空间给数组");
        //最大内存
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
        //可用内存
        System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
        //已用内存
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);

    }
}
