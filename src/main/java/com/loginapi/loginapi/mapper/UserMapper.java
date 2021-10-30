package com.loginapi.loginapi.mapper;

import com.loginapi.loginapi.domain.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper
{
    @Insert("INSERT INTO users1 (account, password) VALUES (#{account}, #{password})")
    public int Insert(@Param("account") String account, @Param("password") String password);

    @Select("select * from users1 where account=#{account}")
    public user select(@Param("account") String account);
}
