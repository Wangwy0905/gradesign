package com.libei.mapper;

import com.libei.entity.AddressEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AddressMapper extends Mapper<AddressEntity> {
    AddressEntity queryDefault(Long userId, Boolean isDefault);

    List<AddressEntity> queryNotDefault(Long userId, Boolean isDefault);
}
