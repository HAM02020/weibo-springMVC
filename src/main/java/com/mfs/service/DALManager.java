package com.mfs.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mfs.dao.TStatusDao;
import com.mfs.entity.TStatus;
import com.mfs.tools.NetworkManager;
import com.mfs.tools.ApplicationContextHelper;



import java.io.IOException;
import java.util.List;

public class DALManager {


    private static TStatusDao tStatusDao = (TStatusDao) ApplicationContextHelper.getBean("TStatusDao");

    public static JSONArray loadStatus(long since_id, long max_id , boolean isPullup) throws IOException {


        //0. 获取用户代号
        Long userId = Long.parseLong(NetworkManager.Shared().getAccess_token().getUid());
        //1. 检查本地数据 如果有 直接返回
        List<TStatus> array = tStatusDao.loadStatus(userId,since_id,max_id);

        //  判断数组的数量
        if (array.size() > 0) {
            JSONArray jsonArray = new JSONArray();
            for(TStatus tStatus:array){
                JSONObject jsonObject = JSON.parseObject(String.valueOf(tStatus.jsonStr));
                jsonArray.add(jsonObject);
            }
            return jsonArray;
        }
        //2. 加载网络数据
        JSONArray statuses = NetworkManager.Shared().getStatusList(since_id,max_id);
        //3. 加载完成后， 将网络数据 写入数据库
        for (Object object : statuses) {
            JSONObject jsonObject = (JSONObject)object;
            long statusId = jsonObject.getLong("id");

            if(tStatusDao.queryById(statusId)==null)
                tStatusDao.insertStatus(userId,statusId,jsonObject.toJSONString());
            else
                tStatusDao.updateStatus(userId,statusId,jsonObject.toJSONString());
        }
        //4. 返回网络数据
        return statuses;

    }


}
