package cn.ltx.designmode.singleton;

/**
 * Description:ö�ٶ���
 *
 * @author litianxiang
 * @date 2019-10-29
 */
public enum HttpEnum {
    HTTP_200(200, "�ɹ�"),
    HTTP_500(500, "ʧ��");

    HttpEnum(Integer code, String msg) {
        System.out.println("��ʼ��" + code);
        this.code = code;
        this.msg = msg;
    }

    ;
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static void main(String[] args) {
        System.out.println(HttpEnum.HTTP_200.getCode());
        System.out.println(HttpEnum.HTTP_200.getMsg());
        System.out.println(HttpEnum.HTTP_500.getCode());
        System.out.println(HttpEnum.HTTP_500.getMsg());
    }
}
