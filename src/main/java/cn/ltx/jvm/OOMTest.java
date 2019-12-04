package cn.ltx.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:内存溢出-分配的内存不够用
 * -Xms1m -Xmx50m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 * -XX:+HeapDumpOnOutOfMemoryError表示当JVM发生OOM时，自动生成DUMP文件。
 * -Xms1m -Xmx50m 要回收4次
 * -Xms50m -Xmx50m 只回收3次
 * -Xms500m -Xmx500m 空间足，就没有必要回收垃圾了
 *
 * @author litianxiang
 * @date 2019-11-22
 */
public class OOMTest {
    public static void main(String[] args) {
        List<Object> listObject = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            System.out.println("i:" + i);
            Byte[] bytes = new Byte[1 * 1024 * 1024];
            listObject.add(bytes);
        }
        System.out.println("成功.");
    }
}
