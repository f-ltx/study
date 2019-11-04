package cn.ltx.concurrent.locksupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    static User user = new User();
    static Thread t1 = new Thread(new Producer());
    static Thread t2 = new Thread(new Consumer());

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t2.start();

    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            int count = 0;
            while (true) {
                if (user.flag) {
                    if (count == 0) {
                        user.name = "zhang";
                        user.sex = "san";
                    } else {
                        user.name = "li";
                        user.sex = "si";
                    }
                    count = (count + 1) % 2;
                    user.flag = false;
                } else {
                    LockSupport.park();
                }
                LockSupport.unpark(t2);
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (!user.flag) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(user.sex + " - " + user.name);
                        user.flag = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    LockSupport.park();
                }
                LockSupport.unpark(t1);
            }
        }
    }

    static class User {
        String name;
        String sex;
        boolean flag;
    }
}
