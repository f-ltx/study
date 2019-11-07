package cn.ltx.test;

public class Test {
    public static void main(String[] args) {
        int a = 4, b = 5;
        Test(a, b);
        System.out.println("a = " + a + ", b = " + b);
    }

    public static void Test(int x, int y) {
        int tmp = x;
        x = y;
        y = tmp;
        System.out.println("x = " + x + ", y = " + y);
    }
}
