package cn.ltx.jvm;

public class FinalizeDemo {
    public static void main(String[] args) {
        FinalizeDemo f1 = new FinalizeDemo();//可达
        f1 = null; //不可达，提示jvm回收
        FinalizeDemo f2 = f1 ;//引用
        System.gc();//提示gc线程进行回收，但不是立即回收，等gc线程被调度了，或者空闲才回收
        //gc线程是守护线程，与主线程绑定的，因为主线程结束了，垃圾回收就没有意义了
    }

    @Override
    protected void finalize() throws Throwable {
        //finalize方法是Object类的方法，是垃圾回收之前一定执行的
        System.out.println("执行finalize方法..");
    }
}
