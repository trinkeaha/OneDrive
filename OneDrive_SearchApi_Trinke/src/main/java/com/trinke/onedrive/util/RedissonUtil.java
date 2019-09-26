package com.trinke.onedrive.util;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedissonUtil {

    private static String ip="39.105.189.141";
    private static int port=6379;
    private static RedissonClient redisson;

    static {
        Config config = new Config();
        config.useSingleServer().setPassword("qfjava").setAddress("redis://"+ip+":"+port).setDatabase(0).setConnectTimeout(5000);
        redisson= Redisson.create(config);
    }

    public static void saveStr(String key, String v) {
        RBucket<String> bucket = redisson.getBucket(key);
        bucket.set(v);
    }

    public static void saveString(String key,String v,int seconds) {
        RBucket<String> bucket = redisson.getBucket(key);
        bucket.set(v,seconds, TimeUnit.SECONDS);
    }

    public static void saveList(String key, List<String> list) {
        redisson.getList(key).addAll(list);
    }

    public static void saveHash(String key, Map<String,String> map) {
        redisson.getMap(key).putAll(map);
    }

    public static void saveSet(String key, Set<String> set) {
        redisson.getSet(key).addAll(set);
    }

    public static void saveZSet(String key,Map<Object,Double> map) {
        redisson.getScoredSortedSet(key).addAll(map);
    }

    public static String getStr(String key) {
        return redisson.getBucket(key).get().toString();
    }

    public static List<String> getList(String key) {
        return redisson.getList(key);
    }

    public static void delKey(String key) {
        redisson.getKeys().delete(key);
    }


    //清空数据
    public static void delList(String key) {
        redisson.getList(key).clear();
    }

}
