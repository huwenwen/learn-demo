package com.wen.autoconfigure.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huwenwen
 * @since 11/08/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = PylonAutoConfiguration.class)
public class PylonAutoConfigurationTest {

    @Test
    public void test(){
        Map<String, String> map = new HashMap<>();
        map.put("123", "123");
    }

}
