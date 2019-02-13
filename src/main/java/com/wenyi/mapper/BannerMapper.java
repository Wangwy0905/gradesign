package com.wenyi.mapper;


import com.wenyi.entity.Banner;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BannerMapper extends Mapper<Banner> {

    List<Banner> queryAllByPage(@Param(value = "rows") int rows, @Param(value = "page") int page);
    Integer queryNum();
    void deleteBanner(Integer id);
    List<Banner> queryAllBanner();


}
