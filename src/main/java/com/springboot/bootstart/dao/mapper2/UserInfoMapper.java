package com.springboot.bootstart.dao.mapper2;

import com.springboot.bootstart.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("db2SqlSessionFactory")
@Mapper
public interface UserInfoMapper {

    @Insert("insert into tb_user(USERNAME,PASSWORD,PHONENUM,EMAIL) values('${userName}','${passWord}','${phoneNum}','${email}')")
    void insert(UserInfo userInfo);

    @Select("select * from tb_user where ID=${id}")
    UserInfo selectByPrimaryId(@Param("id") Integer id);
}
