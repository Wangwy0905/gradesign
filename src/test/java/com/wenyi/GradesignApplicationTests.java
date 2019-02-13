package com.wenyi;

import com.wenyi.entity.Menu;
import com.wenyi.mapper.MenuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GradesignApplicationTests {
    @Autowired
    MenuMapper menuMapper;
    @Test
    public void contextLoads() {
        for (int i = 0; i < 10; i++) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println(uuid);
        }
    }
    @Test
    public void  mappertest(){


        List<Menu> menus = menuMapper.queryAll();

        System.out.println(menus+"````");

    }

}

