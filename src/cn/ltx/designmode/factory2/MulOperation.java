package cn.ltx.designmode.factory2;

/**
 * Description:乘
 *
 * @author Administrator
 * @date 2019/10/24
 */
public class MulOperation extends Operation {
    public MulOperation(double x, double y) {
        super(x, y);
    }

    @Override
    public String getResult() {
        return String.valueOf(super.getX() * super.getY());
    }
}
