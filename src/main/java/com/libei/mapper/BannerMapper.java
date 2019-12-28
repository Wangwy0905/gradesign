package com.libei.mapper;


import com.libei.entity.BannerEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BannerMapper extends Mapper<BannerEntity> {

    List<BannerEntity> queryAllByPage(@Param(value = "rows") int rows, @Param(value = "page") int page);
    Integer queryNum();
    List<BannerEntity> queryAllBanner();


}
