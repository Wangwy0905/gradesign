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
import com.libei.entity.UserEntity;
import com.libei.mapper.AddressMapper;
import com.libei.mapper.UserMapper;
import com.libei.service.AddressService;
import com.libei.util.ListUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressMapper addressMapper = null;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean add(AddressRequest request) {
        AddressEntity addressEntity = new AddressEntity();
        BeanUtils.copyProperties(request, addressEntity);
        addressEntity.setCreateDate(System.currentTimeMillis());
        addressEntity.setIsDefault(false);
        addressMapper.insert(addressEntity);

        return true;
    }

    @Override
    public List<AddressDto> query(Long userId,Boolean isDefault) {

        if (isDefault) {
            AddressEntity addressEntity = addressMapper.queryDefault(userId, isDefault);
            if (addressEntity == null) {
                return null;
            }
            AddressDto addressDto = new AddressDto();
            BeanUtils.copyProperties(addressEntity, addressDto);
            addressDto.setDetailAddress(addressEntity.getProvince()+addressEntity.getCity()+addressEntity.getDetailAddress());
            return Arrays.asList(addressDto);
        }

        List<AddressEntity> addressEntityList = addressMapper.queryNotDefault(userId, isDefault);

        List<AddressDto> list=new ArrayList<>();
        if(CollectionUtils.isEmpty(addressEntityList)){
            return null;
        }
        for (AddressEntity addressEntity:addressEntityList){
            AddressDto addressDto = new AddressDto();
            BeanUtils.copyProperties(addressEntity, addressDto);
            addressDto.setDetailAddress(addressEntity.getProvince()+addressEntity.getCity()+addressEntity.getDetailAddress());
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
    public List<AddressDto> queryBack() {
        List<AddressEntity> addressEntities = addressMapper.queryAll();
        List<AddressDto> addressDtos=new ArrayList<>();

        if (CollectionUtils.isEmpty(addressEntities)){
            return null;
        }
        for (AddressEntity entity: addressEntities){
            AddressDto addressDto=new AddressDto();
            addressDto.setId(entity.getId());
            addressDto.setDetailAddress(entity.getProvince()+entity.getCity()+entity.getDetailAddress());
            addressDto.setIsDefault(entity.getIsDefault());
            addressDto.setRemark(entity.getRemark());
            UserEntity userEntity = userMapper.selectByPrimaryKey(entity.getUserId());
            addressDto.setUserName(userEntity.getAccount());

            addressDtos.add(addressDto);
        }

        return addressDtos;
    }

    @Override
    public List<AddressEntity> queryLike(String param) {
        List<AddressEntity> addressEntities = addressMapper.queryLike(param);
//       List<AddressDto> list=new
//        for ()
        return  addressEntities;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateStatus(Long addressId, Boolean isDefault, Long userId) {
        AddressEntity addressEntity = addressMapper.queryDefault(userId, isDefault);
        if (addressEntity!=null){
            addressEntity.setIsDefault(false);
        }

        AddressEntity entity = addressMapper.selectByPrimaryKey(addressId);
        entity.setIsDefault(true);

        addressMapper.insert(addressEntity);
        addressMapper.insert(entity);

        return true;
    }
}
