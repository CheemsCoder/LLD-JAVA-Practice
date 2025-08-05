package org.example;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashmapExample {
    class ReadWrite implements Runnable {
        private ConcurrentHashMap<String, Integer> map;

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        public ReadWrite(ConcurrentHashMap<String, Integer> map) {
            this.map = map;
        }

        public void write(String key, Integer value) {
            readWriteLock.writeLock().lock();
            try {
                map.put(key, value);
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }

        public Integer read(String key) {
            readWriteLock.readLock().lock();
            try {
                return map.get(key);
            } finally {
                readWriteLock.readLock().unlock();
            }
        }

        @Override
        public void run() {
            for(int i=0;i<10;i++) {
                String key = "key" + i;
                Integer value = i;
                write(key, value);
                System.out.println("Written: " + key + " " + value);
            }
            for(int i=0;i<10;i++) {
                String key = "key" + i;
                Integer value = read(key);
                System.out.println("Read: " + key + " " + value);
            }
        }
    }
    public static void main(String[] args) {

        ConcurrentHashmapExample example = new ConcurrentHashmapExample();
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        ReadWrite readWrite = example.new ReadWrite(map);
        Thread thread1 = new Thread(readWrite);
        Thread thread2 = new Thread(readWrite);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
