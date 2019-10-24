package cn.ltx.designmode.factory2;

import static cn.ltx.designmode.factory1.Client.client;

/**
 * Description:界面
 *
 * @author Administrator
 * @date 2019/10/24
 */
public class Client {
    public static void main(String[] args) {
        try {
            String[] data = client();
            Operation operation = OperationFactory.getOperation(Double.parseDouble(data[0]), data[1], Double.parseDouble(data[2]));
            System.out.println(operation.getResult());
        } catch (Exception e) {
            System.out.println("请输入数字:" + e.getMessage());
        }
    }
}
