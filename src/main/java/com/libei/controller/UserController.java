package com.libei.controller;

import com.libei.controller.request.CommonRequest;
import com.libei.entity.UserEntity;
import com.libei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author li bei
 * @date 2020.1.2
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    //用户查询
    @CrossOrigin
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public List<UserEntity> query() {
        return userService.query();

    }

    //用户删除
    @CrossOrigin
    @GetMapping("delete")
    public Boolean delete(@RequestParam @Valid @NotNull Long id) throws Exception {
        return userService.delete(id);

    }

    //搜索
    @CrossOrigin
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public List<UserEntity> search(@RequestBody CommonRequest commonRequest) {
        return userService.search(commonRequest);

    }

    //用户信息   不提供修改操作
}
