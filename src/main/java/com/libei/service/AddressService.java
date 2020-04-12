package com.libei.service;

import com.libei.Dto.AddressDto;
import com.libei.controller.request.AddressRequest;
import com.libei.entity.AddressEntity;

import java.util.List;

public interface AddressService {
    Boolean add(AddressRequest request);

    List<AddressDto> query(Long userId);

    Boolean delete(Long id) throws Exception;

    Boolean update(AddressRequest request);

    AddressDto queryDetail(Long id) throws Exception;

    List<AddressDto> queryBack();

    List<AddressEntity> queryLike( String account);

    Boolean updateStatus(Long addressId, Boolean isDefault,Long id);
}
