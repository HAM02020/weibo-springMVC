package com.mfs.viewmodel;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mfs.entity.Status;
import com.mfs.service.DALManager;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class StatusListViewModel {
    public List<Status> statusList ;

    public StatusListViewModel() throws IOException, ParseException {
        statusList = new ArrayList<Status>();
        if(statusList.size()>0)
            getStatusList(false);
    }

    public void getStatusList(boolean isLoadMore) throws IOException, ParseException {
        long since_id = 0;
        long max_id = 0;
        if (statusList.size() != 0)
        {
            since_id = isLoadMore ? 0: statusList.get(0).id;
            max_id = !isLoadMore ? 0: statusList.get(statusList.size()-1).id;


        }
        //加载微博

        JSONArray jsonArray = DALManager.loadStatus(since_id,max_id, isLoadMore);

        List<Status> array = new ArrayList<Status>();

        for(Object obj : jsonArray)
        {
            JSONObject j = (JSONObject)obj;
            //把数据 反序列化成模型
            Status status = Status.getInstance(j.toJSONString());

            //创建WBStatusViewModel

            //添加到list中
            array.add(status);
        }
        if (isLoadMore)
        {
            statusList.addAll(array);
        }
        else
        {
            array.addAll(statusList);
            statusList = array;
        }
    }


}

