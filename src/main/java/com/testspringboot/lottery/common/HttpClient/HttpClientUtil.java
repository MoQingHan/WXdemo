package com.testspringboot.lottery.common.HttpClient;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HttpClientUtil {

    public static String doPost(String url, Map params, String requestCharset,String responseCharset, boolean pretty) throws  Exception{
        StringBuffer response = new StringBuffer();
        HttpClient client = new HttpClient();
        dealHttps(url);
        PostMethod method = new PostMethod(url);
        // 设置post数据

        if (null != params) {
            NameValuePair[] data=new NameValuePair[ params.size()];
            Iterator iterator=params.entrySet().iterator();
            int i=0;
            while (iterator.hasNext()) {
                Entry entryTemp = (Entry) iterator.next();
                data[i]=new NameValuePair((String)entryTemp.getKey(), (String) entryTemp.getValue());
                i++;
            }
            method.setRequestBody(data);
        }
        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,requestCharset);
        client.executeMethod(method);
        if (method.getStatusCode() != HttpStatus.SC_OK) {
            throw new Exception("PostMethod StatusCode : " + method.getStatusCode() + " Error !");
        }
        String ret = getResponseRet(method, response, pretty, responseCharset);
        method.releaseConnection();
        return ret;
    }


    public static String doGet(String url, String queryString, String charset, boolean pretty) throws  IOException {
        StringBuffer response = new StringBuffer();
        HttpClient client = new HttpClient();
        dealHttps(url);
        HttpMethod method = new GetMethod(url);
        // 设置 请求头
        method.setRequestHeader("Content-Type", "application/json;charset=" + charset);
        if (StringUtils.isNotBlank(queryString))
            // 对get请求参数编码，汉字编码后，就成为%式样的字符串
            method.setQueryString(URIUtil.encodeQuery(queryString));

        client.executeMethod(method);
        String ret = getResponseRet(method, response, pretty, charset);
        method.releaseConnection();

        return ret;
    }

    private static String getResponseRet(HttpMethod method, StringBuffer response, boolean pretty, String charset) throws IOException {
        if (method.getStatusCode() == HttpStatus.SC_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset));
            String line;
            while (null != (line = reader.readLine())) {
                if (pretty)
                    response.append(line).append(System.getProperty("line.separator"));
                else
                    response.append(line);
            }
            reader.close();
        }
        return response.toString();
    }


    public static String writePost(String url, String content, String charset, boolean pretty) throws Exception{
        StringBuffer response = new StringBuffer();
        HttpClient client = new HttpClient();
        dealHttps(url);
        PostMethod method = new PostMethod(url);

        //设置请求头部类型参数
        //method.setRequestHeader("Content-Type","text/plain; charset=utf-8");//application/json,text/xml,text/plain
        method.setRequestHeader("Content-Type", "application/json; charset=" + charset);
        //method.setRequestBody(content); //InputStream,NameValuePair[],String
        //RequestEntity是个接口，有很多实现类，发送不同类型的数据
        RequestEntity requestEntity = new StringRequestEntity(content, "text/json", charset);//application/json,text/xml,text/plain
        method.setRequestEntity(requestEntity);
        client.executeMethod(method);
        if (method.getStatusCode() != HttpStatus.SC_OK) {
            throw new Exception("PostMethod StatusCode : " + method.getStatusCode() + " Error !");
        }
        getResponseRet(method,response,pretty,charset);
        method.releaseConnection();
        return response.toString();
    }


    private static void dealHttps(String url){
        if (url.startsWith("https")) {
            //https请求
            Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);
            Protocol.registerProtocol("https", myhttps);
        }
    }
}
