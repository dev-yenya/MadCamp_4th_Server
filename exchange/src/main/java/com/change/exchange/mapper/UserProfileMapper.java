package com.change.exchange.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.change.exchange.model.UserProfile;

@Mapper
public interface UserProfileMapper {

    @Select ("select * from UserProfile where id=#{id}")
    UserProfile getUserProfile(@Param("id") String id);

    @Select("select * from UserProfile")
    List<UserProfile> getUserProfileList();

    @Insert("insert into UserProfile values(#{id}, #{name}, #{email})")
    int insertUserProfile(@Param("id") String id, @Param("name") String name, @Param("email") String email);

    @Update("update UserProfile set name=#{name}, email=#{email} where id=#{id}")
    int updateUserProfile(@Param("id") String id, @Param("name") String name, @Param("email") String email);

    @Delete("delete from UserProfile where id=#{id}")
    int deleteUserProfile(@Param("id") String id);

}
