package cn.ltx.designmode.strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        String type = "common";
        Strategy strategy = new Strategy(type);
        strategy.youhui();
        type = "silver";
        strategy = new Strategy(type);
        strategy.youhui();
        type = "gold";
        strategy = new Strategy(type);
        strategy.youhui();
    }
}

class Strategy {
    private Member member;

    public Strategy(String type) {
        if (type.equals("common")) {
            this.member = new CommonMember();
        }
        if (type.equals("silver")) {
            this.member = new SilverMember();
        }
        if (type.equals("gold")) {
            this.member = new GoldMember();
        }
    }

    public void youhui() {
        this.member.youhui();
    }
}

abstract class Member {
    abstract void youhui();
}

class CommonMember extends Member {


    @Override
    public void youhui() {
        System.out.println("普通会员的优惠");
    }
}

class SilverMember extends Member {

    @Override
    public void youhui() {
        System.out.println("白银会员的优惠");
    }
}

class GoldMember extends Member {

    @Override
    public void youhui() {
        System.out.println("黄金会员的优惠");
    }
}