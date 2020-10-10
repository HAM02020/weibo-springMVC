package com.mfs.service;

import com.mfs.dao.AccessTokenDao;
import com.mfs.entity.AccessToken;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessTokenService implements AccessTokenDao {
    @Autowired
    private AccessTokenDao accessTokenDao;

    public AccessToken queryByUId(@Param("uid") String uid){
        return accessTokenDao.queryByUId(uid);
    }


    public List<AccessToken> queryAll(@Param("offset") int offset, @Param("limit") int limit){
        return accessTokenDao.queryAll(offset,limit);
    }


    public void update(AccessToken accessToken){
        accessTokenDao.update(accessToken);
    }


    public void insert(AccessToken accessToken){
        accessTokenDao.insert(accessToken);
    }
}
