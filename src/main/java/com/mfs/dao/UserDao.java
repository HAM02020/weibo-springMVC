package com.mfs.dao;


import com.mfs.entity.AccessToken;
import com.mfs.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao {

    User queryById(String idstr);

    List<User> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    void update(User user);


    void insert(User user);


}
