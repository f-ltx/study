package cn.ltx.designmode.factory2;

/**
 * Description:除
 *
 * @author Administrator
 * @date 2019/10/24
 */
public class DivOperation extends Operation {
    public DivOperation(double x, double y) {
        super(x, y);
    }

    @Override
    public String getResult() {
        return super.getY() != 0 ? String.valueOf(super.getX() / super.getY()) : "除数不能为0";
    }
}
