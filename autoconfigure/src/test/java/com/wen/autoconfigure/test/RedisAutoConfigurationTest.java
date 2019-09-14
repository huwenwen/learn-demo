package com.wen.autoconfigure.test;

import com.wen.autoconfigure.RedisAutoConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author huwenwen
 * @since 29/07/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisAutoConfiguration.class)
public class RedisAutoConfigurationTest {

    @Test
    public void test() {

    }

}
