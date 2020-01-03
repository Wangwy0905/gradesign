package com.libei.service.impl;

import com.libei.Dto.AddressDto;
import com.libei.controller.request.AddressRequest;
import com.libei.entity.AddressEntity;
import com.libei.mapper.AddressMapper;
import com.libei.service.AddressService;
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
    public Boolean add(AddressRequest request) {
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
            //AddressEntity addressEntity = addressMapper.queryDefault(userId, isDefault);

            AddressDto addressDto = new AddressDto();
            //  BeanUtils.copyProperties(addressDto, addressEntity);
            return Arrays.asList(addressDto);
        } else {

        }

        return null;
    }
}
