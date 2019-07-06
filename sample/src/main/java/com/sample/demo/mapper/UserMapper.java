package com.sample.demo.mapper;

import com.sample.demo.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    void registUser(@Param("user") User user);

    User getUserByUsername(@Param("username") String username);

    void update(@Param("user") User user);

    void updateHeadPort(@Param("url") String url, @Param("username") String username);

}
