package com.libei.mapper;

import com.libei.entity.AddressEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AddressMapper extends Mapper<AddressEntity> {
    AddressEntity queryDefault(@Param("userId")Long userId, @Param("isDefault")Boolean isDefault);

    List<AddressEntity> queryAddress(@Param("userId")Long userId);

    List<AddressEntity> queryAll();

    Integer totalNum();

    void deleteByUserId( Long UserId);

    List<AddressEntity> queryLike(Long userId);
}
