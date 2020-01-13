package com.libei.service;

import com.libei.Dto.AddressDto;
import com.libei.controller.request.AddressRequest;

import java.util.List;

public interface AddressService {
    Boolean add(AddressRequest request);

    List<AddressDto> query(AddressRequest request);

    Boolean delete(Long id) throws Exception;

    Boolean update(AddressRequest request);

    AddressDto queryDetail(Long id) throws Exception;
}
