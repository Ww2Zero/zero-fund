package com.zero.fund.dao;

import com.zero.fund.util.MapBeanUtil;
import com.zero.fund.vo.HistoryValueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FundNavDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public void insertNavHistory(List<HistoryValueVo> valueVoList) {

        String sql = "insert into fund_history (CODE,FSRQ,DWJZ,LJJZ,SDATE,ACTUALSYI,NAVTYPE,JZZZL,SGZT,SHZT,FHFCZ,FHFCBZ,DTYPE,FHSP) " +
                "values (:CODE,:FSRQ,:DWJZ,:LJJZ,:SDATE,:ACTUALSYI,:NAVTYPE,:JZZZL,:SGZT,:SHZT,:FHFCZ,:FHFCBZ,:DTYPE,:FHSP)";

        jdbcTemplate.batchUpdate(sql, MapBeanUtil.beanList2MapArray(valueVoList));
    }


}
