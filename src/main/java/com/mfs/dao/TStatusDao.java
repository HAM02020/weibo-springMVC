package com.mfs.dao;

import com.mfs.entity.TStatus;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;


public interface TStatusDao {

    TStatus queryById(long statusId);

    ArrayList<TStatus> loadStatus(@Param("userId") long userId, @Param("sinceId")long sinceId, @Param("maxId") long maxId);

    void insertStatus(@Param("userId") long userId, @Param("statusId") long statusId, @Param("jsonStr") String jsonStr);

    void updateStatus(@Param("userId") long userId,@Param("statusId") long statusId,@Param("jsonStr") String jsonStr);

}
