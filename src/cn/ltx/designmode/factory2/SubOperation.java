package cn.ltx.designmode.factory2;

/**
 * Description:减
 *
 * @author Administrator
 * @date 2019/10/24
 */
public class SubOperation extends Operation {
    public SubOperation(double x, double y) {
        super(x, y);
    }

    @Override
    public String getResult() {
        return String.valueOf(super.getX() - super.getY());
    }
}
