package com.pd.backend.service;

import com.pd.backend.common.R;
import com.pd.backend.entity.logindto.LoginDto;
import com.pd.backend.entity.vo.LoginVo;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/2/27 19:48
 */
public interface LoginService {

    R<LoginDto> login(LoginVo loginVo);
}
