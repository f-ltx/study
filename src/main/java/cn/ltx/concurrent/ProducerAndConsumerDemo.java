package cn.ltx.concurrent;

/**
 * Description:生产者与消费者
 *
 * @author Administrator
 * @date 2019/10/30
 */
public class ProducerAndConsumerDemo {
    public static void main(String[] args) {
        User user = new User();
        new Thread(new Producer(user)).start();
        new Thread(new Consumer(user)).start();
    }
}

class Producer implements Runnable {
    public Producer(User user) {
        this.user = user;
    }

    private User user;
    private int count = 0;

    @Override
    public void run() {
        //利用死循环一直生产对象
        while (true) {
            synchronized (user) {
                //flag == true 执行生产
                if (user.flag) {
                    try {
                        user.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (count == 0) {
                        user.setName("老铁头");
                        user.setSex("男");
                    } else {
                        user.setName("老妹");
                        user.setSex("女");
                    }
                    count = (count + 1) % 2;
                    user.flag = false;
                }
                user.notify();
            }
        }
    }
}

class Consumer implements Runnable {
    private User user;

    public Consumer(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        //利用死循环一直读
        while (true) {
            synchronized (user) {
                //flag == false 执行生产消费
                if (!user.flag) {
                    try {
                        user.wait();
                        System.out.println(user.getName() + " - " + user.getSex());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.flag = true;
                }
                user.notify();
            }
        }
    }
}

/**
 * Description:共享资源
 *
 * @author Administrator
 * @date 2019/10/30
 */
class User {
    private String name;
    private String sex;
    public boolean flag = true;

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}