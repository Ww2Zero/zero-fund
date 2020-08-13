package com.zero.fund.vo;

public class QueryDataVo {


            private HistoryValueDataVo Data;
            private String ErrCode;
            private String ErrMsg;
            private String TotalCount;
            private String Expansion;
            private String PageSize;
            private String PageIndex;

    public HistoryValueDataVo getData() {
        return Data;
    }

    public void setData(HistoryValueDataVo data) {
        Data = data;
    }

    public String getErrCode() {
        return ErrCode;
    }

    public void setErrCode(String errCode) {
        ErrCode = errCode;
    }

    public String getErrMsg() {
        return ErrMsg;
    }

    public void setErrMsg(String errMsg) {
        ErrMsg = errMsg;
    }

    public String getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(String totalCount) {
        TotalCount = totalCount;
    }

    public String getExpansion() {
        return Expansion;
    }

    public void setExpansion(String expansion) {
        Expansion = expansion;
    }

    public String getPageSize() {
        return PageSize;
    }

    public void setPageSize(String pageSize) {
        PageSize = pageSize;
    }

    public String getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(String pageIndex) {
        PageIndex = pageIndex;
    }

    @Override
    public String toString() {
        return "QueryDataVo{" +
                "Data=" + Data +
                ", ErrCode='" + ErrCode + '\'' +
                ", ErrMsg='" + ErrMsg + '\'' +
                ", TotalCount='" + TotalCount + '\'' +
                ", Expansion='" + Expansion + '\'' +
                ", PageSize='" + PageSize + '\'' +
                ", PageIndex='" + PageIndex + '\'' +
                '}';
    }
}
