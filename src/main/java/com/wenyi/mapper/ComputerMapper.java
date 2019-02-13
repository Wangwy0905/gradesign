package com.wenyi.mapper;

import com.wenyi.entity.Computer;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ComputerMapper extends Mapper<Computer> {
        public  Integer totalNum();
        public List<Computer> queryAll(@Param(value = "id") int id,@Param(value = "page") int page, @Param(value = "rows") int rows);
}
