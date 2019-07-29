package com.liyan.mapper;

import com.liyan.pojo.Users;
import org.apache.ibatis.annotations.Select;

public interface UsersMapper {
    @Select("select * from users where username=#{username} and password=#{password}")
    Users findByUserPwd(Users users);
}
