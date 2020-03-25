package com.libei.service;

import com.libei.Dto.AppraiseResDto;
import com.libei.controller.request.AppraiseRequest;
import com.libei.controller.request.CommonRequest;

public interface AppraiseService {
    Boolean add(AppraiseRequest request);

    Boolean delete(Long id);

    AppraiseResDto query(CommonRequest commonRequest);
}
