package org.bird.breeze.edu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserFuncMapperTest {

    @Autowired
    private UserFuncMapper userFuncMapper;

    @Test
    public void testSelectUserFunc(){
        System.out.println(userFuncMapper.selectUserFunc(1));
    }
}
