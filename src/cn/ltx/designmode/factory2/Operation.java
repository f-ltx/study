package cn.ltx.designmode.factory2;

/**
 * Description:操作类
 *
 * @author Administrator
 * @date 2019/10/24
 */
public class Operation {
    private double x;
    private double y;
    private String o;

    public Operation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String getResult() {
        return "输入的操作符有误";
    }

    public Operation() {

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }
}
