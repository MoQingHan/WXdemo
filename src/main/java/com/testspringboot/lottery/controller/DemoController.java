package com.testspringboot.lottery.controller;

import com.testspringboot.lottery.common.WechatUtil;
import com.testspringboot.lottery.pojo.WechatVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {
    @RequestMapping("testDemo")
    public String  testDemo( @RequestBody WechatVO id){
        System.out.println(id);
        String result = WechatUtil.decryptData(id.getEncryptedData(),id.getSignature(),id.getIv());
        System.out.println(result);
        return "hello world";
    }

    @RequestMapping("testCode")
    public String  testCode(@RequestBody String js_code){
        try {
            String rs=WechatUtil.code2session(js_code);
            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(js_code);
       // String result = WechatUtil.decryptData(id.getEncryptedData(),id.getSignature(),id.getIv());
       // System.out.println(result);
        return "testCode";
    }

    public void register(){

    }
}
