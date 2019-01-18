package com.testspringboot.lottery.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.testspringboot.lottery.common.WechatUtil;
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

@RestController
@RequestMapping("demo")
public class DemoController {
    @Autowired
    DemoService demoService;
    @RequestMapping("testDemo")
    public String  testDemo(@RequestBody WechatVO id, HttpServletRequest request){
        String result = WechatUtil.decryptData(id.getEncryptedData(),(String)request.getSession().getAttribute("session_key"),id.getIv());
        String jg=(String) request.getSession().getAttribute("test");
        return jg;
    }

    @RequestMapping("wxlogin")
    public String  login(@RequestBody String js_code, HttpServletRequest request){
        if(StringUtils.isBlank(js_code)){
            return null;
        }
        HttpSession session=request.getSession();
        //SessionBean sessionbean=(SessionBean)session.getAttribute("session");
        String sessionid=session.getId();
        try {
            String rs=WechatUtil.code2session(js_code);//换取openid 和session_key
            if(StringUtils.isNotBlank(rs)){
                JsonObject jsonObject=(JsonObject) new JsonParser().parse(rs);
                String session_key=jsonObject.get("session_key").getAsString();
                String openid=jsonObject.get("openid").getAsString();
                //用openid查询user
                User user=demoService.getUserByOpenid(openid);
                if(user==null){
                    User user1=new User();
                    user1.setOpenid(openid);
                    demoService.insertUser(user1);
                    session.setAttribute("session",user1);
                }else{
                    session.setAttribute("session",user);
                }
               /* String unionid=null;
                if(jsonObject.has("unionid")){
                    unionid=jsonObject.get("unionid").getAsString();
                }*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionid;
    }

    public void register(){

    }
}
