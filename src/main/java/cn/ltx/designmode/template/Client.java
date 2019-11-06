package cn.ltx.designmode.template;

public class Client {
    public static void main(String[] args) {
        MsgTemplate yidong = new YidongMsg();
        yidong.sendMsg();
        MsgTemplate liantong = new LiantongMsg();
        liantong.sendMsg();
    }
}

class YidongMsg extends MsgTemplate {
    @Override
    void httpRequest() {
        System.out.println("调用移动短信接口...");
    }
}

class LiantongMsg extends MsgTemplate {
    @Override
    void httpRequest() {
        System.out.println("调用联通短信接口...");
    }
}

abstract class MsgTemplate {
    public void sendMsg() {
        this.addHeadLog();
        this.httpRequest();
        this.addFootLog();
    }

    public void addHeadLog() {
        System.out.println("记录头日志，开始调用短信发送接口");
    }

    abstract void httpRequest();

    public void addFootLog() {
        System.out.println("记录尾日志，结束调用短信发送接口");
    }
}

