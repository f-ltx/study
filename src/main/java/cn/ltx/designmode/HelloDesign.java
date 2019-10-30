package cn.ltx.designmode;

import java.util.Scanner;

public class HelloDesign {
    public static void main(String[] args) {
        System.out.println("请输入：");
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        System.out.println(nextLine);
    }
}
