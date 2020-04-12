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
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
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
        entity.setCreateDate(System.currentTimeMillis());
        appraiseMapper.insert(entity);

        return true;
    }

    @Override
    public Boolean delete(Long id) {
        appraiseMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public List<AppraiseDto> queryLike(Long userId) {

        List<AppraiseEntity> appraiseEntities= appraiseMapper.queryLike(userId);

        List<AppraiseDto> appraiseDtos = ListUtils.entityListToModelList(appraiseEntities, AppraiseDto.class);
        for (AppraiseDto appraiseDto :appraiseDtos){
            Long id = appraiseDto.getId();
            UserEntity userEntity = userMapper.selectByPrimaryKey(id);
            appraiseDto.setAccount(userEntity.getAccount());
        }

        return appraiseDtos;
    }

    @Override
    public List<AppraiseDto> query(Long productId) {

        List<AppraiseEntity> appraiseEntities= appraiseMapper.queryAll(productId);

        List<AppraiseDto> appraiseDtos = ListUtils.entityListToModelList(appraiseEntities, AppraiseDto.class);
        if (CollectionUtils.isEmpty(appraiseDtos)){
            return null;
        }
        for (AppraiseDto appraiseDto :appraiseDtos){
            Long id = appraiseDto.getUserId();
            UserEntity userEntity = userMapper.selectByPrimaryKey(id);
            appraiseDto.setAccount(userEntity.getAccount());
        }

        return appraiseDtos;
    }
}
