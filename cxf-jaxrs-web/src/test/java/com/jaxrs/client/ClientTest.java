package com.jaxrs.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.jaxrs.client.pojo.User;

public class ClientTest {

    public static void main(String[] args) {

        JSONObject zhangsan = new JSONObject();
        try {
            //添加
            zhangsan.put("name", "张三");
            zhangsan.put("age", 18.4);
            zhangsan.put("birthday", "1900-20-03");
            zhangsan.put("majar", new String[] {"哈哈","嘿嘿"});
            zhangsan.put("null", null);
            zhangsan.put("house", false);
            System.out.println(zhangsan.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
