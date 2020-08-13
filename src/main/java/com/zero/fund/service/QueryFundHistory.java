package com.zero.fund.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zero.fund.dao.FundNavDao;
import com.zero.fund.util.HttpUtil;
import com.zero.fund.vo.HistoryValueVo;
import com.zero.fund.vo.HttpClientResult;
import com.zero.fund.vo.QueryDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zero
 */
@Component
public class QueryFundHistory {

    @Autowired
    FundNavDao fundNavDao;

    public  void getFundNavHistory() throws Exception {

        String burl = "http://api.fund.eastmoney.com/f10/lsjz?callback=jQuery183&fundCode=320007&pageIndex=12&pageSize=20&startDate=&endDate=&_=1597286638733";
        String url = "http://api.fund.eastmoney.com/f10/lsjz";

        HashMap<String, String> headers = new HashMap<>();
        headers.put("DNT", "1");
        headers.put("Host", "fund.eastmoney.com");
        headers.put("If-None-Match", "b56a685e-f638-4ccc-820d-c0495e577277");
        headers.put("Referer", "http://fund.eastmoney.com/data/fundranking.html");
        headers.put("Upgrade-Insecure-Requests", "1");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537. 36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36");
        HashMap<String, String> params = new HashMap<>();
        params.put("callback", "jQuery183");
        params.put("fundCode", "320007");
        params.put("pageIndex", "1");
        params.put("pageSize", "200");
        params.put("startDate", "");
        params.put("endDate", "");
        params.put("_", "1597286638733");

        HttpClientResult httpClientResult = HttpUtil.doGet(url,headers,params);
        System.out.println("httpClientResult = " + httpClientResult);

        String content = httpClientResult.getContent();
        String jsonString = content.substring("jQuery183(".length(), content.length() - 1);
        System.out.println("jsonString = " + jsonString);



        GsonBuilder gsonBuilder = new GsonBuilder();
        // 设置日期转换格式
        gsonBuilder.setDateFormat("yyyy-MM--dd");
        Gson gson = gsonBuilder.create();
        //解析对象：第一个参数：待解析的字符串 第二个参数结果数据类型的Class对象
        QueryDataVo user = gson.fromJson(jsonString, QueryDataVo.class);

        System.out.println("user = " + user);
        List<HistoryValueVo> lsjzList = user.getData().getLSJZList();
        List<HistoryValueVo> collect = lsjzList.stream().map(v -> {
            v.setCODE("320007");
            return v;
        }).collect(Collectors.toList());
        fundNavDao.insertNavHistory(collect);
    }


}
