package com.tang.learn.usercenter.service;

/**
 * @author tang
 * @Classname 对象和数组都以json形式进行存储
 * @Description TODO
 * @Date 2019/11/23 16:41
 */
public interface RedisService {
    /**
     * 存储数据
     */
    void set(String key, String value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超期时间
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);

}
