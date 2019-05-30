package com.itheima.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-09-12:28
 */
public class JedisPoolUtils {
    private static JedisPool pool;

    static {

        ResourceBundle bundle = ResourceBundle.getBundle("Jedis");

        int maxTotal = Integer.parseInt(bundle.getString("jedis.maxTotal"));
        int maxIdle = Integer.parseInt(bundle.getString("jedis.maxIdle"));
        String host = bundle.getString("jedis.host");
        int port = Integer.parseInt(bundle.getString("jedis.port"));

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        pool = new JedisPool(config, host, port);
    }

    public static Jedis getJedis() {
        return pool.getResource();
    }

    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
