package cn.ltx.designmode.facecade;

public class FacecadeDemo {
    public static void main(String[] args) {
        new Facecade().sendMsg();
    }
}

class Facecade {
    private MailMsg mailMsg;
    private WechatMsg wechatMsg;
    private SSMMsg ssmMsg;

    public Facecade() {
        this.mailMsg = new MailMsg();
        this.wechatMsg = new WechatMsg();
        this.ssmMsg = new SSMMsg();
    }

    public void sendMsg() {
        this.mailMsg.sendMsg();
        this.wechatMsg.sendMsg();
        this.ssmMsg.sendMsg();
    }
}

class MailMsg {
    public void sendMsg() {
        System.out.println("mail send ...");
    }
}

class WechatMsg {
    public void sendMsg() {
        System.out.println("wechat send ...");
    }
}

class SSMMsg {
    public void sendMsg() {
        System.out.println("SSM send ...");
    }
}