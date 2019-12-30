package com.libei;

import com.libei.entity.Admin;
import com.libei.entity.MenuEntity;
import com.libei.mapper.MenuMapper;
import com.libei.util.ListUtils;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GradesignApplicationTests {
    //    @Autowired
//    MenuMapper menuMapper;
//    @Test
//    public void contextLoads() {
//        for (int i = 0; i < 10; i++) {
//            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//            System.out.println(uuid);
//        }
//    }
    @Test
    public void mappertest() {

//        List<Admin> list = new ArrayList<>();
//
//        list.add(new Admin(1, "12", "w", "1", 1));
//        list.add(new Admin(2, "12", "w", "", 1));
//        list.add(new Admin(3, "12", "w", "", 1));
//        list.add(new Admin(4, "12", "w", "", 1));
//        list.add(new Admin(5, "12", "w", "", 1));

        //  List<Admin> copyList = new ArrayList<>();
//
//        List<Admin> admins = ListUtils.entityListToModelList(list, Admin.class);
//
//        System.out.println(admins);
    }

    @Test
    public void mappetest() {
        String code = "1234";
        code = DigestUtils.sha1DigestAsHex(code);

        System.out.println(code);


    }


}

