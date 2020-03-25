package com.libei.service.impl;

import com.libei.Dto.AdminDetailDto;
import com.libei.Dto.AdminDto;
import com.libei.Dto.AppraiseDto;
import com.libei.Dto.AppraiseResDto;
import com.libei.controller.request.AppraiseRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.entity.AdminEntity;
import com.libei.entity.AppraiseEntity;
import com.libei.mapper.AppraiseMapper;
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
    public AppraiseResDto query(CommonRequest commonRequest) {
        int pageNum = commonRequest.getPageNum();
        int pageSize = commonRequest.getPageSize();

        List<AppraiseEntity> appraiseDtos = appraiseMapper.queryAll(pageNum, pageSize);
        Integer integer = appraiseMapper.totalNum();

        AppraiseResDto appraiseResDto = new AppraiseResDto();
        appraiseResDto.setTotal(integer);
        appraiseResDto.setRows(ListUtils.entityListToModelList(appraiseDtos, AppraiseDto.class));

        return appraiseResDto;
    }
}
