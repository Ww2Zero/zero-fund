package com.zero.fund.vo;

import java.util.List;

public class HistoryValueDataVo {


            private List<HistoryValueVo> LSJZList;
            private String FundType;
            private String SYType;
            private String isNewType;
            private String Feature;

    public List<HistoryValueVo> getLSJZList() {
        return LSJZList;
    }

    public void setLSJZList(List<HistoryValueVo> LSJZList) {
        this.LSJZList = LSJZList;
    }

    public String getFundType() {
        return FundType;
    }

    public void setFundType(String fundType) {
        FundType = fundType;
    }

    public String getSYType() {
        return SYType;
    }

    public void setSYType(String SYType) {
        this.SYType = SYType;
    }

    public String getIsNewType() {
        return isNewType;
    }

    public void setIsNewType(String isNewType) {
        this.isNewType = isNewType;
    }

    public String getFeature() {
        return Feature;
    }

    public void setFeature(String feature) {
        Feature = feature;
    }

    @Override
    public String toString() {
        return "HistoryValueDataVo{" +
                "LSJZList=" + LSJZList +
                ", FundType='" + FundType + '\'' +
                ", SYType='" + SYType + '\'' +
                ", isNewType='" + isNewType + '\'' +
                ", Feature='" + Feature + '\'' +
                '}';
    }
}
