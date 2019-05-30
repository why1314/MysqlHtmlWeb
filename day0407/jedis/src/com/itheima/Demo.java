package com.itheima;

import redis.clients.jedis.Jedis;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-09-12:19
 */
public class Demo {
    public static void main(String[] args) {
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("name","tom");
        JedisPoolUtils.close(jedis);
    }
}
