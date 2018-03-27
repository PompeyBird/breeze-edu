package org.bird.breeze.edu.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilsTest {
    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void testSetAndGet(){
        redisUtils.set("test_key","test_value");
        System.out.println(redisUtils.get("test_key"));
    }
}
