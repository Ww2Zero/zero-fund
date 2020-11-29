package com.zero.fund.util;

import com.google.gson.JsonObject;
import com.zero.fund.vo.HttpClientResult;

import java.util.HashMap;

/**
 * @author zero
 */

public class MsgUtil {


    private static final String ServerUrl="https://sc.ftqq.com/";
    public static final String pushToken="";
    private MsgUtil() {
    }

    public static void pushMsg(String text,String msg) throws Exception {

        String url = ServerUrl + pushToken + ".send";

        HashMap<String, String> pushBody = new HashMap<String, String>();
        pushBody.put("text",text);
        pushBody.put("desp",msg);
        HttpClientResult httpClientResult = HttpUtil.doPost(url, pushBody);
    }

}
