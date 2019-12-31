package com.libei.mapper;


import com.libei.entity.BannerEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BannerMapper extends Mapper<BannerEntity> {

    List<BannerEntity> queryByPage(@Param(value = "pageSize") int pageSize, @Param(value = "pageNum") int pageNum);

    Integer queryNum();

    List<BannerEntity> queryLike(@Param(value = "pageSize") int pageSize, @Param(value = "pageNum") int pageNum, @Param("param") String param);

    List<BannerEntity> query();


}
