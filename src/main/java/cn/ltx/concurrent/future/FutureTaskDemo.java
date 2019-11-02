package cn.ltx.concurrent.future;

import java.util.concurrent.*;

public class FutureTaskDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3));
        Future<String> submit = threadPoolExecutor.submit(new ExecuteThread());
        System.out.println("main...1");
        new Thread(new RecieveThread(submit)).start();
        System.out.println("main...2");
        threadPoolExecutor.shutdown();
    }
}

class RecieveThread implements Runnable {
    private Future<String> submit;

    public RecieveThread(Future<String> submit) {
        this.submit = submit;
    }

    @Override
    public void run() {
        try {
            System.out.println("recieve : " + this.submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class ExecuteThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("执行任务。。。。。需要5秒");
        Thread.sleep(5000);
        System.out.println("执行完毕，返回结果");
        return "success";
    }
}