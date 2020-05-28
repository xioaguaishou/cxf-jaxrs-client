package com.jaxrs.client.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jaxrs.client.pojo.User;
import com.jaxrs.client.vo.Result;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Controller
@RequestMapping("user") // 窄化请求映射
public class UserController {

    @Value("${baseURI}")
    private String baseURI;

    @GetMapping("/{id}")
    public void get(@PathVariable String id) {
        WebClient webClient = WebClient.create(baseURI + "user/");
        webClient.path(id);
        webClient.accept(MediaType.WILDCARD);
        String jsonString = webClient.get(String.class);
        Result result = JSONObject.parseObject(jsonString, Result.class);
        System.out.println("get: " + result);
    }

    // 请求方式
    @PostMapping
    public void post(User user) {
        WebClient webClient = WebClient.create(baseURI + "user/");
        // 设置响应数据类型
        webClient.accept(MediaType.APPLICATION_JSON);
        webClient.acceptEncoding("gzip, deflate, br"); // 设置响应数据编码
        webClient.acceptLanguage("zh-CN,zh;q=0.9"); // 设置语言
        // 设置请求头信息: 发送数据类型
        webClient.type(MediaType.APPLICATION_JSON);

        // 对象转json字符串
        String jsonString = webClient.post(JSON.toJSONString(user), String.class);
        Result result = JSONObject.parseObject(jsonString, Result.class);
        System.out.println("post: " + result);
    }

    @PutMapping
    public void put(User user) {
        WebClient webClient = WebClient.create(baseURI + "user/");
        // 设置请求头信息: 发送数据类型
        webClient.type(MediaType.APPLICATION_JSON);
        // 设置响应数据类型
        webClient.accept(MediaType.APPLICATION_JSON);
        webClient.acceptEncoding("gzip, deflate, br"); // 设置响应数据编码
        webClient.acceptLanguage("zh-CN,zh;q=0.9"); // 设置语言

        String jsonString = webClient.put(JSON.toJSONString(user), String.class);
        Result result = JSONObject.parseObject(jsonString, Result.class);
        System.out.println("put: " + result);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        WebClient webClient = WebClient.create(baseURI + "user/");
        webClient.path(id);
        webClient.accept(MediaType.WILDCARD);
        Response response = webClient.delete();
        String jsonString = response.readEntity(String.class);
        Result result = JSONObject.parseObject(jsonString, Result.class);
        System.out.println("delete: " + result);
    }

    @RequestMapping(path = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public void queryList(User user) {
        WebClient webClient = WebClient.create(baseURI + "user/list");
        // 设置请求头信息: 发送数据类型
        webClient.type(MediaType.APPLICATION_JSON);
        // 设置响应数据类型
        webClient.accept(MediaType.APPLICATION_JSON);
        webClient.acceptEncoding("gzip, deflate, br"); // 设置响应数据编码
        webClient.acceptLanguage("zh-CN,zh;q=0.9"); // 设置语言

        // 对象转json字符串
        String jsonString = webClient.post(JSON.toJSONString(user), String.class);
        System.out.println(jsonString);
        Result result = JSONObject.parseObject(jsonString, Result.class);
        System.out.println(result);
    }

}


