package com.mfs.dao;


import com.mfs.entity.AccessToken;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

public interface AccessTokenDao {


    AccessToken queryByUId(@Param("uid")String uid);


    List<AccessToken> queryAll(@Param("offset") int offset, @Param("limit") int limit);


    void update(AccessToken accessToken);


    void insert(AccessToken accessToken);
}
