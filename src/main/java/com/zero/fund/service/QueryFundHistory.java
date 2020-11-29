package com.zero.fund.service;

import com.zero.fund.dao.FundNavDao;
import com.zero.fund.util.FundUtil;
import com.zero.fund.vo.QueryDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zero
 */
@Component
public class QueryFundHistory {

    @Autowired
    FundNavDao fundNavDao;

    public  void getFundNavHistory() throws Exception {

        QueryDataVo queryDataVo = FundUtil.queryFundNavHistory("320007");

//        fundNavDao.insertNavHistory(queryDataVo.getData().getLSJZList());
    }
}
