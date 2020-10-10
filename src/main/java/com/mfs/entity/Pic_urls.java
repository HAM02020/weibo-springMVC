package com.mfs.entity;

import java.util.ArrayList;

public class Pic_urls {
    public ArrayList<String> thumbnail_pic;
    public Pic_urls()
    {
        thumbnail_pic = new ArrayList<String>();
    }


    public ArrayList<String> getThumbnail_pic() {
        return thumbnail_pic;
    }

    public void setThumbnail_pic(ArrayList<String> thumbnail_pic) {
        this.thumbnail_pic = thumbnail_pic;
    }

    @Override
    public String toString() {
        return "Pic_urls{" +
                "thumbnail_pic=" + thumbnail_pic +
                '}';
    }
}
