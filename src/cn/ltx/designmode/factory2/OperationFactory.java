package cn.ltx.designmode.factory2;

/**
 * Description:工厂
 *
 * @author Administrator
 * @date 2019/10/24
 */
public class OperationFactory {
    public static Operation getOperation(double x, String o, double y) {
        switch (o) {
            case "+":
                return new AddOperation(x, y);
            case "-":
                return new SubOperation(x, y);
            case "*":
                return new MulOperation(x, y);
            case "/":
                return new DivOperation(x, y);
            default:
                return new Operation(x, y);
        }
    }
}
