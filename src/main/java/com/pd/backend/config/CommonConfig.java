package com.pd.backend.config;

import com.pd.backend.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author byzhao
 * @version 1.0
 * @description 公共配置类
 * @date 2022/10/1 21:54:41
 */
@Configuration
public class CommonConfig {

    /**
     *  密码加密器  BCryptPasswordEncoder 采用 SHA-256 算法
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置id生成器bean
     * @return
     */
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }

}