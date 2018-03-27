package org.bird.breeze.edu.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key, String value) {
        this.stringRedisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, String value, long expire) {
        this.stringRedisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
    }
    public String get(String key) {
        return this.stringRedisTemplate.opsForValue().get(key);
    }
    public void delete(String key) {
        this.stringRedisTemplate.delete(key);
    }
}
