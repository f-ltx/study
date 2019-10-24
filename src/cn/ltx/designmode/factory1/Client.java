package cn.ltx.designmode.factory1;

import java.util.Scanner;

/**
 * Description:业务逻辑与界面逻辑分开，界面逻辑
 *
 * @author Administrator
 * @date 2019/10/24
 */
public class Client {
    public static void main(String[] args) {
        try {
            String[] data = client();
            System.out.println("结果:" + Operation.getResult(Double.parseDouble(data[0]), data[1], Double.parseDouble(data[2])));
        } catch (Exception e) {
            System.out.println("请输入数字:" + e.getMessage());
        }
    }

    public static String[] client() {
        String[] array = new String[3];
        System.out.println("计算器示例：");
        System.out.println("请输入第一个数：");
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        System.out.println("请输入操作符：+、-、*、/");
        String o = scanner.nextLine();
        System.out.println("请输入第二个数：");
        String y = scanner.nextLine();
        array[0] = x;
        array[1] = o;
        array[2] = y;
        return array;
    }
}
