package com.mfs.service;

import com.mfs.dao.TStatusDao;
import com.mfs.entity.TStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TStatusService implements TStatusDao {

    @Qualifier("TStatusDao")
    @Autowired
    private TStatusDao tStatusDao;


    @Override
    public TStatus queryById(long statusId) {
        return tStatusDao.queryById(statusId);
    }

    @Override
    public ArrayList<TStatus> loadStatus(long userId, long sinceId, long maxId) {
        return tStatusDao.loadStatus(userId,sinceId,maxId);
    }

    @Override
    public void insertStatus(long userId, long statusId, String jsonStr) {
        tStatusDao.insertStatus(userId,statusId,jsonStr);
    }

    @Override
    public void updateStatus(long userId, long statusId, String jsonStr) {
        tStatusDao.updateStatus(userId,statusId,jsonStr);
    }
}
