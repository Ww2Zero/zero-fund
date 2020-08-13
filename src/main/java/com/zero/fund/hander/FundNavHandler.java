package com.zero.fund.hander;

import com.zero.fund.service.QueryFundHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author zero
 */
@Component
public class FundNavHandler implements ApplicationRunner {

    @Autowired
    QueryFundHistory queryFundHistory;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        queryFundHistory.getFundNavHistory();
    }
}
