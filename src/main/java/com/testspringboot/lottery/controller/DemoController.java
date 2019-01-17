package com.testspringboot.lottery.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.testspringboot.lottery.common.WechatUtil;
import com.testspringboot.lottery.pojo.WechatVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("demo")
public class DemoController {
    @RequestMapping("testDemo")
    public String  testDemo(@RequestBody WechatVO id, HttpServletRequest request){
        String result = WechatUtil.decryptData(id.getEncryptedData(),(String)request.getSession().getAttribute("session_key"),id.getIv());
        String jg=(String) request.getSession().getAttribute("test");
        return jg;
    }

    @RequestMapping("login")
    public String  login(@RequestBody String js_code, HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("test","测试session");
        String sessionid=session.getId();
        try {
            String rs=WechatUtil.code2session(js_code);
            if(StringUtils.isNotBlank(rs)){
                JsonObject jsonObject=(JsonObject) new JsonParser().parse(rs);
                //System.out.println(jsonObject.get("session_key").getAsString());
                //System.out.println(jsonObject.get("openid").getAsString());
                session.setAttribute("session_key",jsonObject.get("session_key").getAsString());
            }
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(js_code);
       // String result = WechatUtil.decryptData(id.getEncryptedData(),id.getSignature(),id.getIv());
       // System.out.println(result);
        System.out.println(sessionid);
        return sessionid;
    }

    public void register(){

    }
}
