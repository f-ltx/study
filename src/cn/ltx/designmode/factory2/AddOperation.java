package cn.ltx.designmode.factory2;

/**
 * Description:加
 *
 * @author Administrator
 * @date 2019/10/24
 */
public class AddOperation extends Operation {
    public AddOperation(double x, double y) {
        super(x, y);
    }

    @Override
    public String getResult() {
        return String.valueOf(super.getX() + super.getY());
    }
}
