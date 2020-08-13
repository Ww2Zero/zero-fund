package com.zero.fund;

import com.zero.fund.service.QueryFundHistory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = QueryFundHistoryTest.class)
public class QueryFundHistoryTest {


    @Autowired
    QueryFundHistory queryFundHistory;

    @Test
    public void getFundNavHistory() throws Exception {
        queryFundHistory.getFundNavHistory();;
    }
}