package com.pd.backend.mapper;

import com.pd.backend.entity.PdAuthUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Chandler
* @description 针对表【pd_auth_user】的数据库操作Mapper
* @createDate 2023-02-27 17:16:47
* @Entity com.pd.backend.entity.PdAuthUser
*/
@Mapper
public interface PdAuthUserMapper {

    PdAuthUser selectByAccount(@Param("account") String account);
}




