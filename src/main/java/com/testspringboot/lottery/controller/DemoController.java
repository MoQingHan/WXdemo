package com.testspringboot.lottery.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.testspringboot.lottery.common.WechatUtil;
import com.testspringboot.lottery.pojo.Bet;
import com.testspringboot.lottery.pojo.User;
import com.testspringboot.lottery.pojo.WechatVO;
import com.testspringboot.lottery.service.DemoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("lottery")
public class DemoController {
    @Autowired
    DemoService demoService;
    @RequestMapping("updateWxInfo")
    public String  updateWxInfo(@RequestBody WechatVO wo, HttpServletRequest request){
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("session");
        user.setHeadUrl(wo.getUserInfo().getAvatarUrl());
        user.setNickName(wo.getUserInfo().getNickName());
        demoService.updateUserInfo(user);
        Map m=new HashMap();
        m.put("flag","1");
        return new Gson().toJson(m);
    }

    /**
     * 微信小程序登陆
     * @param js_code
     * @param request
     * @return
     */
    @RequestMapping("wxlogin")
    public String  wxlogin(@RequestBody String js_code, HttpServletRequest request){
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("session");
        String sessionid=session.getId();
        String money="";
        try {
            String rs=WechatUtil.code2session(js_code);
            if(StringUtils.isNotBlank(rs)){
                JsonObject jsonObject=(JsonObject) new JsonParser().parse(rs);
                String sessionKey=jsonObject.get("session_key").getAsString();
                String openid=jsonObject.get("openid").getAsString();
                User u=demoService.getUserByOpenid(openid);
                if(u==null){
                    u=demoService.addUser(openid);
                }
                session.setAttribute("session",u);
                money=u.getMoney()+"";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String,String> m=new HashMap<String,String>();
        m.put("money", money);
        m.put("sessionid", sessionid);
        Gson gson=new Gson();
        return gson.toJson(m);
    }

    /**
     * 得到用户信息
     * @param request
     * @return
     */
    @RequestMapping("getUserInfo")
    public String getUserInfo(HttpServletRequest request){
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("session");
        User u=demoService.addUser(user.getOpenid());
        session.setAttribute("session",u);
        Map<String,String> m=new HashMap<String,String>();
        if(u.getMoney()==null){
            u.setMoney(0);
        }
        m.put("money", u.getMoney()+"");
        Gson gson=new Gson();
        return gson.toJson(m);
    }


    /**
     * 得到用户信息
     * @param request
     * @return
     */
    @RequestMapping("bet")
    public String bet(@RequestBody Bet bet, HttpServletRequest request){
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("session");
        String rs=demoService.bet(user,bet.getBetcount(),bet.getBetnum());
        return rs;
    }

    @RequestMapping("addMoney")
    public String addMoney(@RequestBody Bet bet){

        return demoService.addMoney(bet.getUser_id(),bet.getMoney());
    }

    @RequestMapping("register")
    public String register(@RequestBody Bet bet){
        demoService.addUser(bet.getUser_name(),bet.getUser_pwd());
        Map m=new HashMap();
        m.put("flag","1");
        return new Gson().toJson(m);
    }

    @RequestMapping("login")
    public String login(@RequestBody Bet bet,HttpServletRequest request){
        String flag="1";
        String msg="登陆成功";
        User u =demoService.login(bet.getUser_name(),bet.getUser_pwd());
        HttpSession session=request.getSession();
        if(u!=null){
            session.setAttribute("session",u);
        }else{
            flag="0";
            msg="登陆失败";
        }
        Map m=new HashMap();
        m.put("flag",flag);
        m.put("errMsg",msg);
        return new Gson().toJson(m);
    }

    @RequestMapping("getAllWxUser")
    public String getAllWxUser(){
        List<User> list =demoService.selectAllWxUser();
        return new Gson().toJson(list);
    }
}
