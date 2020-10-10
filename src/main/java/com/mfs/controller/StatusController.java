package com.mfs.controller;

import com.mfs.dao.AccessTokenDao;
import com.mfs.dao.UserDao;
import com.mfs.entity.Status;
import com.mfs.entity.User;
import com.mfs.viewmodel.StatusListViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RequestMapping("/status")
@Controller
public class StatusController {

    @Autowired
    AccessTokenDao accessTokenDao;
    @Autowired
    UserDao userDao;

    Integer pageNum = 2;

    StatusListViewModel listViewModel = new StatusListViewModel();

    public StatusController() throws IOException, ParseException {
    }

    @RequestMapping("/timeline")
    @ResponseBody
    public ModelAndView getStatus() throws IOException, ParseException {

        pageNum=2;
        ModelAndView view = new ModelAndView("main");

        //调用DAL从本地获取数据 或者 从网络加载，并存入数据库
        listViewModel.getStatusList(false);


        view.addObject("user",getUser());
        view.addObject("statusList",listViewModel.statusList.subList(0,20));
        view.addObject("pageNum",pageNum);


        return view;
    }

    @RequestMapping("/timeline/nextpage")
    @ResponseBody
    public ModelAndView nextPage(HttpServletRequest request) throws IOException, ParseException {

        ModelAndView view = new ModelAndView("main");

        view.addObject("user",getUser());

        //调用DAL从本地获取数据 或者 从网络加载，并存入数据库

        Integer reqPage = Integer.parseInt(request.getQueryString().split("=")[1]);

        if(reqPage<pageNum){
            System.out.println("点击刷新");
            view.addObject("pageNum",pageNum);
            view.addObject("statusList",listViewModel.statusList.subList(listViewModel.statusList.size()-20,listViewModel.statusList.size()));
            return view;
        }
        view.addObject("pageNum",++pageNum);
        System.out.println("点击下一页");
        listViewModel.getStatusList(true);
        List<Status> statusList = listViewModel.statusList.subList(listViewModel.statusList.size()-20,listViewModel.statusList.size());
        view.addObject("statusList",statusList);
        return view;
    }


    private User getUser(){
        return userDao.queryAll(0,2).get(0);
    }
}
