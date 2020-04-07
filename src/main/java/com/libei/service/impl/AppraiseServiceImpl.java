package com.libei.service.impl;

import com.libei.Dto.AppraiseDto;
import com.libei.controller.request.AppraiseRequest;
import com.libei.entity.AppraiseEntity;
import com.libei.entity.UserEntity;
import com.libei.mapper.AppraiseMapper;
import com.libei.mapper.UserMapper;
import com.libei.service.AppraiseService;
import com.libei.util.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppraiseServiceImpl implements AppraiseService {
    @Autowired
    private AppraiseMapper appraiseMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean add(AppraiseRequest request) {
        AppraiseEntity entity = new AppraiseEntity();
        BeanUtils.copyProperties(request, entity);
        entity.setCreateDate(new Date());
        appraiseMapper.insert(entity);

        return true;
    }

    @Override
    public Boolean delete(Long id) {
        appraiseMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public List<AppraiseDto> query() {

        List<AppraiseEntity> appraiseEntities= appraiseMapper.queryAll();

        List<AppraiseDto> appraiseDtos = ListUtils.entityListToModelList(appraiseEntities, AppraiseDto.class);
        for (AppraiseDto appraiseDto :appraiseDtos){
            Long id = appraiseDto.getId();
            UserEntity userEntity = userMapper.selectByPrimaryKey(id);
            appraiseDto.setUserName(userEntity.getAccount());
        }

        return appraiseDtos;
    }
}
