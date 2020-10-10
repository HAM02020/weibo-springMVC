package com.mfs.controller;

import com.alibaba.fastjson.JSONObject;
import com.mfs.dao.UserDao;
import com.mfs.entity.User;
import com.mfs.tools.NetworkManager;
import com.mfs.http.WBCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller

public class MainController {

    @Autowired
    private UserDao userDao;




    @RequestMapping("/login")
    public String login(){
        String url = "https://api.weibo.com/oauth2/authorize?client_id="+WBCommon.WBAppKey+"&redirect_uri="+ WBCommon.WBRedirectURI;
        return "redirect:"+url;
    }
    @RequestMapping("/home")
    public String index(){
        return "redirect: /status/timeline";
    }



    @RequestMapping("/ame")
    public ModelAndView ame(){
        ModelAndView view = new ModelAndView("msg_ame");
        User user = userDao.queryAll(0,2).get(0);
        view.addObject("user",user);
        return view;
    }
    @RequestMapping("/comment")
    public ModelAndView comment(){
        ModelAndView view = new ModelAndView("msg_comment");
        User user = userDao.queryAll(0,2).get(0);
        view.addObject("user",user);
        return view;
    }
    @RequestMapping("/attitude")
    public ModelAndView attitude(){
        ModelAndView view = new ModelAndView("msg_attitude");
        User user = userDao.queryAll(0,2).get(0);
        view.addObject("user",user);
        return view;
    }
    @RequestMapping("/private")
    public ModelAndView privateMessage(){
        ModelAndView view = new ModelAndView("msg_private");
        User user = userDao.queryAll(0,2).get(0);
        view.addObject("user",user);
        return view;
    }
    @RequestMapping("/profile")
    public ModelAndView users(){
        ModelAndView view = new ModelAndView("profile");
        User user = userDao.queryAll(0,2).get(0);
        view.addObject("user",user);
        return view;
    }
    @RequestMapping("/discover")
    public ModelAndView discover(){
        ModelAndView view = new ModelAndView("discover");
        User user = userDao.queryAll(0,2).get(0);
        view.addObject("user",user);
        return view;
    }

    public void getReminds(){
        new Thread(()->{
            while(true){
                User user = userDao.queryAll(0,2).get(0);
                try {
                    JSONObject json = NetworkManager.Shared().getReminds(Long.parseLong(user.idstr));



                    Thread.currentThread().sleep(1000 * 60);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
    }

}
