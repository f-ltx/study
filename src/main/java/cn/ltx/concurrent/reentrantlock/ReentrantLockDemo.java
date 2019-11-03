package cn.ltx.concurrent.reentrantlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        final Cache cache = new Cache();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    cache.write(String.valueOf(i), "i = " + i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    cache.read(String.valueOf(i));
                }
            }
        }).start();
    }
}

class Cache {
    private volatile Map<String, String> cache = new HashMap<String, String>();
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void write(String key, String value) {
        try {
            rwl.writeLock().lock();
            System.out.println("write - key = " + key + ",value = " + value);
            this.cache.put(key, value);
        } catch (Exception e) {

        } finally {
            rwl.writeLock().unlock();
        }

    }

    public void read(String key) {
        try {
            rwl.readLock().lock();
            String value = this.cache.get(key);
            System.out.println("read - value = " + value);
        } catch (Exception e) {

        } finally {
            rwl.readLock().unlock();
        }

    }

}

