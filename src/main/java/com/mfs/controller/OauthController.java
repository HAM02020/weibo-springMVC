package com.mfs.controller;

import com.mfs.dao.AccessTokenDao;
import com.mfs.dao.UserDao;
import com.mfs.entity.AccessToken;
import com.mfs.entity.User;
import com.mfs.tools.NetworkManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/oauth")
public class OauthController {
    @Autowired
    private AccessTokenDao accessTokenDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/callback")
    public String getCode(HttpServletRequest request) throws IOException {
        String code = request.getQueryString().replaceAll("code=","");

        //获取Accesstoken
        String rep =  NetworkManager.Shared().getAccessToken(code).body().string();

        AccessToken accessToken = new AccessToken(rep);
        NetworkManager.Shared().setAccess_token(accessToken);
        System.out.println(accessToken.toString());
        if(accessTokenDao.queryByUId(accessToken.getUid())==null)
            accessTokenDao.insert(accessToken);
        else
            accessTokenDao.update(accessToken);
        //获取用户信息
        String userinfo_resp = NetworkManager.Shared().getUserInfo(Long.parseLong(accessToken.getUid()));
        User user = User.getInstance(userinfo_resp);
        if(userDao.queryById(user.getIdstr())==null)
            userDao.insert(user);
        else
            userDao.update(user);

        return "redirect:/status/timeline";
    }

}
