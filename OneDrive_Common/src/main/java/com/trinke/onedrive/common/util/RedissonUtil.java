package com.trinke.onedrive.common.util;


import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @program: OneDrive
 * @description: 基于Redisson 实现对Redis操作
 * @author: Feri
 * @create: 2019-09-25 11:24
 */
public class RedissonUtil {
    private static String ip="39.105.189.141";
    private static int port=6379;
    private static RedissonClient redisson;
    static {
        Config config=new Config();
        config.useSingleServer().setPassword("qfjava").setAddress("redis://"+ip+":"+port).
                setDatabase(0).setConnectTimeout(5000);
        redisson=Redisson.create(config);
    }

    //新增 操作字符串
    public static void saveStr(String key,String v){
        RBucket<String> bucket=redisson.getBucket(key);
        bucket.set(v);
    }
    public static void saveStr(String key,String v,int seconds){
        RBucket<String> bucket=redisson.getBucket(key);
        bucket.set(v,seconds, TimeUnit.SECONDS);
    }
    //新增 操作List
    public static void saveList(String key, List<String> list){
        redisson.getList(key).addAll(list);
    }
    //新增 操作Hash
    public static void saveHash(String key, Map<String,String> map){
        redisson.getMap(key).putAll(map);
    }
    //新增 操作Set
    public static void saveSet(String key, Set<String> set){
        redisson.getSet(key).addAll(set);
    }
    //新增 操作ZSet
    public static void saveZSet(String key, Map<Object,Double> map){
        redisson.getScoredSortedSet(key).addAll(map);
    }

    //查询 字符串
    public static String getStr(String key){
        return redisson.getBucket(key).get().toString();
    }
    //查询 List集合
    public static List<String> getList(String key){
        return redisson.getList(key);
    }
    //删除
    public static void delKey(String key){
        redisson.getKeys().delete(key);
    }

    //情况数据
    public static void delList(String key){
        redisson.getList(key).clear();
    }

    //验证Key存在
    public static  boolean checkKey(String key){
        return redisson.getKeys().countExists(key)>0;
    }
}
