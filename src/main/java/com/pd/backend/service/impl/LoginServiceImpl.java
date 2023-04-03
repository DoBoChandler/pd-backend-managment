package com.pd.backend.service.impl;

import com.google.common.collect.Maps;
import com.pd.backend.common.R;
import com.pd.backend.entity.PdAuthUser;
import com.pd.backend.entity.logindto.LoginDto;
import com.pd.backend.entity.logindto.LoginSexDto;
import com.pd.backend.entity.logindto.LoginTokenDto;
import com.pd.backend.entity.logindto.LoginUserDto;
import com.pd.backend.entity.vo.LoginVo;
import com.pd.backend.enums.ResponseCode;
import com.pd.backend.mapper.PdAuthUserMapper;
import com.pd.backend.service.LoginService;
import com.pd.backend.utils.JwtUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/2/27 19:49
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PdAuthUserMapper pdAuthUserMapper;
    /**
     * redis存储验证码key前缀
     */
    private static final String CAPTCHA_REDIS_PREFIX = "captcha:";
    /**
     * redis存储验证码过期时间
     */
    private static final int CAPTCHA_EXPIRE_TIME = 60;
    @Override
    public R<LoginDto> login(LoginVo loginVo) {
        String account = loginVo.getAccount();
        String code = loginVo.getCode();
        String key = loginVo.getKey();
        String password = loginVo.getPassword();
        String tenant = loginVo.getTenant();
        if(Objects.isNull(loginVo)||
                StringUtils.isBlank(account)||
                StringUtils.isBlank(password)||
                StringUtils.isBlank(code)){
            return R.error(ResponseCode.DATA_ERROR.getMessage());
        }
        PdAuthUser pdAuthUser=pdAuthUserMapper.selectByAccount(account);
        if(pdAuthUser==null){
            return R.error(ResponseCode.SYSTEM_PASSWORD_ERROR.getMessage());
        }
        boolean matches = passwordEncoder.matches(password, pdAuthUser.getPassword());
        if(!matches){
            return R.error(ResponseCode.SYSTEM_PASSWORD_ERROR.getMessage());
        }
        LoginSexDto sex=new LoginSexDto();
        sex.setCode(pdAuthUser.getSex());
        if("M".equals(pdAuthUser.getSex())){
            sex.setDesc("男");
        }
        if("W".equals(pdAuthUser.getSex())){
            sex.setDesc("女");
        }
        if("N".equals(pdAuthUser.getSex())){
            sex.setDesc("未知");
        }

        LoginUserDto loginUserDto=new LoginUserDto();
        BeanUtils.copyProperties(pdAuthUser,loginUserDto);
        loginUserDto.setSex(sex);

        LoginTokenDto loginTokenDto=new LoginTokenDto();
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("account",account);
        map.put("id",loginUserDto.getId());
        String token = jwtUtils.generateToken(map);
        Date date = jwtUtils.getExpirationDateFromToken(token);
        loginTokenDto.setToken(token);
        loginTokenDto.setExpire(date);

        String[] permissionsList={"org:add", "role:config", "resource:add", "resource:update", "resource:delete", "org:update", "org:delete", "org:view", "org:import"};

        LoginDto loginDto=new LoginDto();
        loginDto.setToken(loginTokenDto);
        loginDto.setUser(loginUserDto);
        loginDto.setPermissionsList(permissionsList);
        return R.ok("ok",loginDto,true);
    }
}
