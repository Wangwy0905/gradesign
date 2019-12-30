package com.libei.service.impl;

import com.libei.entity.ProductEntity;
import com.libei.mapper.IndexMapper;
import com.libei.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class IndexServiceImpl implements IndexService {
   @Autowired
    IndexMapper indexMapper;
    @Override
    public ProductEntity queryOne(Integer id) {
        ProductEntity computer = indexMapper.selectByPrimaryKey(id);
        return  computer;
    }
}
