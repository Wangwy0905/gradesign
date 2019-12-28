package com.libei.service;

import com.libei.Dto.ComputerDto;
import com.libei.controller.backController.request.PhoneCommitRequest;
import com.libei.controller.backController.request.PhoneQueryRequest;
import com.libei.entity.PhoneEntity;

public interface PhoneService {
    ComputerDto queryAll(Integer pageNum, Integer  pageSize);

    Boolean addPhone(PhoneCommitRequest request);

    Boolean delete(Integer id);

    Boolean update(PhoneCommitRequest request);

    Boolean queryOne(PhoneQueryRequest request);
}
