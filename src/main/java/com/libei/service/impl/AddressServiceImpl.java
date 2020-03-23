package com.libei.service.impl;

import com.libei.Dto.AddressDto;
import com.libei.controller.request.AddressRequest;
import com.libei.entity.AddressEntity;
import com.libei.mapper.AddressMapper;
import com.libei.service.AddressService;
import com.libei.util.ListUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper = null;

    @Override
    public Boolean  add(AddressRequest request) {
        AddressEntity addressEntity = new AddressEntity();
        BeanUtils.copyProperties(addressEntity, request);

        addressMapper.insert(addressEntity);

        return true;
    }

    @Override
    public List<AddressDto> query(AddressRequest request) {
        Long userId = request.getUserId();
        Boolean isDefault = request.getIsDefault();

        if (isDefault) {
            AddressEntity addressEntity = addressMapper.queryDefault(userId, isDefault);

            AddressDto addressDto = new AddressDto();
            BeanUtils.copyProperties(addressDto, addressEntity);
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

        addressEntity.setStatus("0");

        addressMapper.insert(addressEntity);

        return true;
    }

    @Override
    public Boolean update(AddressRequest request) {

        AddressEntity addressEntity = new AddressEntity();
        BeanUtils.copyProperties(addressEntity, request);

        addressMapper.insert(addressEntity);

        return true;
    }

    @Override
    public AddressDto queryDetail(Long id) throws Exception {
        AddressEntity addressEntity = addressMapper.selectByPrimaryKey(id);

        AddressDto addressDto = new AddressDto();

        BeanUtils.copyProperties(addressDto, addressEntity);

        return addressDto;

    }


}
