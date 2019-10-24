package cn.ltx.designmode.factory1;

/**
 * Description:业务逻辑与界面逻辑分开，业务逻辑
 *
 * @author Administrator
 * @date 2019/10/24
 */
public class Operation {
    public static String getResult(double a, String operation, double b) {
        switch (operation) {
            case "+":
                return String.valueOf(a + b);
            case "-":
                return String.valueOf(a - b);
            case "*":
                return String.valueOf(a * b);
            case "/":
                return b != 0 ? String.valueOf(a / b) : "除数不能为0";
            default:
                return "操作符输入有误:" + operation;
        }
    }
}
