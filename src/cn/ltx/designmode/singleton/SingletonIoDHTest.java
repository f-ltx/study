package cn.ltx.designmode.singleton;

public class SingletonIoDHTest {
    public static void main(String[] args) {
        SingletonIoDH singletonIoDH1 = SingletonIoDH.getInstance();
        SingletonIoDH singletonIoDH2 = SingletonIoDH.getInstance();
        System.out.println(singletonIoDH1);
        System.out.println(singletonIoDH2);
    }
}
