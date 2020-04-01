package com.libei.service;

import com.libei.Dto.AddressDto;
import com.libei.Dto.AddressResDto;
import com.libei.controller.request.AddressRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.entity.AddressEntity;

import java.util.List;

public interface AddressService {
    Boolean add(AddressRequest request);

    List<AddressDto> query(AddressRequest request);

    Boolean delete(Long id) throws Exception;

    Boolean update(AddressRequest request);

    AddressDto queryDetail(Long id) throws Exception;

    List<AddressEntity> queryBack();
}
