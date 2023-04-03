package com.pd.backend.controller;

import com.pd.backend.common.R;
import com.pd.backend.entity.vo.LoginVo;
import com.pd.backend.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chandler
 * @version 2021.2
 * @date 2023/2/27 19:23
 */
@RestController
@Slf4j
@RequestMapping("/api/authority/ann")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public R login(@RequestBody LoginVo loginVo){
        R r=loginService.login(loginVo);
        return r;
    }
}
