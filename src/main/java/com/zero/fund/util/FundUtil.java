package com.zero.fund.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zero.fund.vo.HistoryValueVo;
import com.zero.fund.vo.HttpClientResult;
import com.zero.fund.vo.QueryDataVo;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author zero
 */
public class FundUtil {

    private FundUtil() {
    }

    public static QueryDataVo queryFundNavHistory(String fundCode) throws Exception {
        return queryFundNavHistory(fundCode, 1, 200);
    }


    public static QueryDataVo queryFundNavHistory(String fundCode, Integer pageNum, Integer pageSize) throws Exception {

        if (fundCode.length() != 6) {
            return null;
        }

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
        params.put("fundCode", fundCode);
        params.put("pageIndex", pageNum.toString());
        params.put("pageSize", pageSize.toString());
        params.put("startDate", "");
        params.put("endDate", "");
        params.put("_", "1597286638733");

        HttpClientResult httpClientResult = HttpUtil.doGet(url, headers, params);

        String content = httpClientResult.getContent();
        String jsonString = content.substring("jQuery183(".length(), content.length() - 1);
        GsonBuilder gsonBuilder = new GsonBuilder();
        // 设置日期转换格式
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();
        //解析对象：第一个参数：待解析的字符串 第二个参数结果数据类型的Class对象
        QueryDataVo queryDataVo = gson.fromJson(jsonString, QueryDataVo.class);

        if (Objects.equals(queryDataVo.getErrCode(), 0)) {
            if (!queryDataVo.getData().getLSJZList().isEmpty()) {
                List<HistoryValueVo> historyValueVos = queryDataVo.getData().getLSJZList().stream().map(v -> setFundCode(v, fundCode)).collect(Collectors.toList());
                queryDataVo.getData().setLSJZList(historyValueVos);
            }
        }
        return queryDataVo;

    }

    private static HistoryValueVo setFundCode(HistoryValueVo historyValueVo, String fundCode) {
        historyValueVo.setCODE(fundCode);
        return historyValueVo;
    }
}
