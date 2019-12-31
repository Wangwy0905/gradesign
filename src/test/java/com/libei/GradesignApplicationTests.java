package com.libei;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.test.context.junit4.SpringRunner;

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

//        List<AdminEntity> list = new ArrayList<>();
//
//        list.add(new AdminEntity(1, "12", "w", "1", 1));
//        list.add(new AdminEntity(2, "12", "w", "", 1));
//        list.add(new AdminEntity(3, "12", "w", "", 1));
//        list.add(new AdminEntity(4, "12", "w", "", 1));
//        list.add(new AdminEntity(5, "12", "w", "", 1));

        //  List<AdminEntity> copyList = new ArrayList<>();
//
//        List<AdminEntity> admins = ListUtils.entityListToModelList(list, AdminEntity.class);
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

