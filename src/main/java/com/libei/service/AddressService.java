package com.libei.service;

import com.libei.Dto.AddressDto;
import com.libei.Dto.AddressResDto;
import com.libei.controller.request.AddressRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.entity.AddressEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AddressService {
    Boolean add(AddressRequest request);

    List<AddressDto> query(Long userId,Boolean isDefault);

    Boolean delete(Long id) throws Exception;

    Boolean update(AddressRequest request);

    AddressDto queryDetail(Long id) throws Exception;

    List<AddressDto> queryBack();

    List<AddressEntity> queryLike( String param);

    Boolean updateStatus(Long addressId, Boolean isDefault,Long id);
}
