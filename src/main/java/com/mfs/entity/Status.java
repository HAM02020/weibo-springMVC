package com.mfs.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Status {
    public long id;
    public String idstr;

    public String text ;

    public String created_at;

    public Date createdDate ;
    //来源

    public String source ;
    //转发评论数

    public int reposts_count ;

    public int comments_count ;

    public int attitudes_count ;
    //用户

    public User user ;

    //图片链接
    @JSONField(serialize = false,deserialize = false)
    public Pic_urls pic_urls ;

    public Status retweeted_status ;

    private Status(){}

    public static Status getInstance(String jsonstr){

        JSONObject jsonObject = JSON.parseObject(jsonstr);
        Status status = JSON.parseObject(jsonstr,Status.class);

        status.created_at = Status.formatDate(status.created_at);




        JSONArray picUrlArray = status.retweeted_status!=null? JSON.parseArray(jsonObject.getJSONObject("retweeted_status").getString("pic_urls")):JSON.parseArray(jsonObject.getString("pic_urls"));

        Pic_urls pic_urls = new Pic_urls();
        if(picUrlArray.size()!=1)
        {
            for(Object object : picUrlArray){
                JSONObject json = (JSONObject)object;
                String urlString = json.getString("thumbnail_pic");
                urlString = urlString.replaceAll("thumbnail","thumb300");
                pic_urls.thumbnail_pic.add(urlString);
            }
        }else {
            JSONObject jb = (JSONObject) picUrlArray.get(0);
            String urlStr = jb.getString("thumbnail_pic");
            urlStr = urlStr.replaceAll("thumbnail","wap360");
            pic_urls.thumbnail_pic.add(urlStr);
        }
        if(status.retweeted_status==null)
            status.pic_urls = pic_urls;
        else
            status.retweeted_status.pic_urls = pic_urls;


        return status;
    }

    public static String formatDate(String originDateStr){


        SimpleDateFormat wbDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = wbDateFormat.parse(originDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = format.format(date);

        return result;


    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getReposts_count() {
        return reposts_count;
    }

    public void setReposts_count(int reposts_count) {
        this.reposts_count = reposts_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getAttitudes_count() {
        return attitudes_count;
    }

    public void setAttitudes_count(int attitudes_count) {
        this.attitudes_count = attitudes_count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pic_urls getPic_urls() {
        return pic_urls;
    }

    public void setPic_urls(Pic_urls pic_urls) {
        this.pic_urls = pic_urls;
    }

    public Status getRetweeted_status() {
        return retweeted_status;
    }

    public void setRetweeted_status(Status retweeted_status) {
        this.retweeted_status = retweeted_status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "idstr='" + idstr + '\'' +
                ", text='" + text + '\'' +
                ", created_at='" + created_at + '\'' +
                ", createdDate=" + createdDate +
                ", source='" + source + '\'' +
                ", reposts_count=" + reposts_count +
                ", comments_count=" + comments_count +
                ", attitudes_count=" + attitudes_count +
                ", user=" + user +
                ", pic_urls=" + pic_urls +
                ", retweeted_status=" + retweeted_status +
                '}';
    }
}
