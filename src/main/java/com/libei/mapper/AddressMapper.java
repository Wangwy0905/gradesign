package com.libei.mapper;

import com.libei.entity.AddressEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AddressMapper extends Mapper<AddressEntity> {
    AddressEntity queryDefault(@Param("userId")Long userId, @Param("isDefault")Boolean isDefault);

    List<AddressEntity> queryNotDefault(@Param("userId")Long userId, @Param("isDefault")Boolean isDefault);

    List<AddressEntity> queryAll();

    Integer totalNum();
}
