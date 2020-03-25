package com.libei.service.impl;

import com.libei.Dto.AddressDto;
import com.libei.Dto.AddressResDto;
import com.libei.Dto.AppraiseDto;
import com.libei.Dto.AppraiseResDto;
import com.libei.controller.request.AddressRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.entity.AddressEntity;
import com.libei.entity.AppraiseEntity;
import com.libei.entity.ProductEntity;
import com.libei.mapper.AddressMapper;
import com.libei.service.AddressService;
import com.libei.util.ListUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper = null;

    @Override
    public Boolean add(AddressRequest request) {
        AddressEntity addressEntity = new AddressEntity();
        BeanUtils.copyProperties(request, addressEntity);
        addressEntity.setCreateDate(new Date());
        addressEntity.setIsDefault(false);
        addressMapper.insert(addressEntity);

        return true;
    }

    @Override
    public List<AddressDto> query(AddressRequest request) {
        Long userId = request.getUserId();
        Boolean isDefault = request.getIsDefault();

        if (isDefault) {
            AddressEntity addressEntity = addressMapper.queryDefault(userId, isDefault);
            if (addressEntity == null) {
                return null;
            }
            AddressDto addressDto = new AddressDto();
            BeanUtils.copyProperties(addressEntity, addressDto);
            return Arrays.asList(addressDto);
        }

        List<AddressEntity> addressEntityList = addressMapper.queryNotDefault(userId, isDefault);
        return ListUtils.entityListToModelList(addressEntityList, AddressDto.class);
    }

    @Override
    public Boolean delete(Long id) throws Exception {
        AddressEntity addressEntity = addressMapper.selectByPrimaryKey(id);
        if (addressEntity == null) {
            throw new Exception("查询地址为空，请校验数据");
        }

        addressMapper.deleteByPrimaryKey(id);

        return true;
    }

    @Override
    public Boolean update(AddressRequest request) {
        Long id = request.getId();
        AddressEntity addressEntity = addressMapper.selectByPrimaryKey(id);

        BeanUtils.copyProperties(request, addressEntity);

        addressMapper.updateByPrimaryKey(addressEntity);

        return true;
    }

    @Override
    public AddressDto queryDetail(Long id) throws Exception {
        AddressEntity addressEntity = addressMapper.selectByPrimaryKey(id);

        AddressDto addressDto = new AddressDto();

        BeanUtils.copyProperties(addressEntity, addressDto);

        return addressDto;

    }

    @Override
    public AddressResDto queryBack(CommonRequest commonRequest) {
        int pageNum = commonRequest.getPageNum();
        int pageSize = commonRequest.getPageSize();

        List<AddressEntity> addressEntities = addressMapper.queryAll(pageNum, pageSize);
        Integer integer = addressMapper.totalNum();

        AddressResDto addressResDto = new AddressResDto();
        addressResDto.setTotal(integer);
        addressResDto.setRows(ListUtils.entityListToModelList(addressEntities, AddressDto.class));

        return addressResDto;
    }


}
