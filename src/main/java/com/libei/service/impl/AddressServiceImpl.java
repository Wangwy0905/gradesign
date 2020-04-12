package com.libei.service.impl;

import com.libei.Dto.AddressDto;
import com.libei.controller.request.AddressRequest;
import com.libei.entity.AddressEntity;
import com.libei.entity.UserEntity;
import com.libei.mapper.AddressMapper;
import com.libei.mapper.UserMapper;
import com.libei.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper = null;
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean add(AddressRequest request) {
        AddressEntity addressEntity = new AddressEntity();
        AddressEntity entity =null;
        if (request.getIsDefault()) {
            entity=addressMapper.queryDefault(request.getUserId(), request.getIsDefault());
            if (entity != null) {
                entity.setIsDefault(false);
            }
        }
        BeanUtils.copyProperties(request, addressEntity);
        addressEntity.setCreateDate(System.currentTimeMillis());
        addressMapper.insert(addressEntity);
        addressMapper.updateByPrimaryKey(entity);

        return true;
    }

    @Override
    public List<AddressDto> query(Long userId) {

 /*       if (isDefault) {
            AddressEntity addressEntity = addressMapper.queryDefault(userId, isDefault);
            if (addressEntity == null) {
                return null;
            }
            AddressDto addressDto = new AddressDto();
            BeanUtils.copyProperties(addressEntity, addressDto);
            addressDto.setDetailAddress(addressEntity.getProvince()+addressEntity.getCity()+addressEntity.getDetailAddress());
            return Arrays.asList(addressDto);
        }*/
        List<AddressEntity> addressEntityList = addressMapper.queryAddress(userId);

        List<AddressDto> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(addressEntityList)) {
            return null;
        }
        for (AddressEntity addressEntity : addressEntityList) {
            AddressDto addressDto = new AddressDto();
            BeanUtils.copyProperties(addressEntity, addressDto);
            list.add(addressDto);
        }
        return list;
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
    @Transactional(rollbackFor =Exception.class)
    public Boolean update(AddressRequest request) {
        Long id = request.getId();
        AddressEntity addressEntity = addressMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(request, addressEntity);
        AddressEntity entity =null;
        if (request.getIsDefault()) {
            entity=addressMapper.queryDefault(request.getUserId(), request.getIsDefault());
            if (entity != null) {
                entity.setIsDefault(false);
            }
        }
        addressMapper.updateByPrimaryKey(addressEntity);
        addressMapper.updateByPrimaryKey(entity);
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
    public List<AddressDto> queryBack() {
        List<AddressEntity> addressEntities = addressMapper.queryAll();
        List<AddressDto> addressDtos = new ArrayList<>();

        if (CollectionUtils.isEmpty(addressEntities)) {
            return null;
        }
        for (AddressEntity entity : addressEntities) {
            AddressDto addressDto = new AddressDto();
            addressDto.setId(entity.getId());
            addressDto.setDetailAddress(entity.getProvince() + entity.getCity() + entity.getDetailAddress());
            addressDto.setIsDefault(entity.getIsDefault());
            addressDto.setRemark(entity.getRemark());
            UserEntity userEntity = userMapper.selectByPrimaryKey(entity.getUserId());
            addressDto.setGainName(userEntity.getAccount());

            addressDtos.add(addressDto);
        }

        return addressDtos;
    }

    @Override
    public List<AddressEntity> queryLike(String account) {

        UserEntity userEntity = userMapper.query(account);

        List<AddressEntity> addressEntities = addressMapper.queryLike(userEntity.getId());

        if (CollectionUtils.isEmpty(addressEntities)) {
            return null;
        }
        return addressEntities;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateStatus(Long addressId, Boolean isDefault, Long userId) {
        AddressEntity addressEntity = addressMapper.queryDefault(userId, isDefault);
        if (addressEntity != null) {
            addressEntity.setIsDefault(false);
        }

        AddressEntity entity = addressMapper.selectByPrimaryKey(addressId);
        entity.setIsDefault(true);

        addressMapper.updateByPrimaryKey(addressEntity);
        addressMapper.updateByPrimaryKey(entity);

        return true;
    }
}
