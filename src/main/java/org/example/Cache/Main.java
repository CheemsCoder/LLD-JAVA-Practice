package org.example.Cache;

import org.example.Cache.Factory.CacheFactory;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CacheFactory<String, String> cacheFactory = new CacheFactory<>();
        Cache<String, String> cache = cacheFactory.defaultCache(3);

        cache.put("k1", "v1", 3000);
        System.out.println("Put K1 at t0");
        Thread.sleep(5000);
        cache.put("K2", "V2", 3000);
        System.out.println("Try get K1: " + cache.get("K1"));


//        System.out.println("Get A: " + cache.get("A"));
//
//        cache.put("D", "Date");
//
//        System.out.println("Get B: " + cache.get("B"));
//        System.out.println("Get C: " + cache.get("C"));
//        System.out.println("Get D: " + cache.get("D"));
    }
}
