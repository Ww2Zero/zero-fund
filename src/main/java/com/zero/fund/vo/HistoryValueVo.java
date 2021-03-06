package com.zero.fund.vo;

/**
 * "FSRQ": "2019-09-16",
 * "DWJZ": "1.0780",
 * "LJJZ": "1.5230",
 * "SDATE": null,
 * "ACTUALSYI": "",
 * "NAVTYPE": "1",
 * "JZZZL": "1.22",
 * "SGZT": "开放申购",
 * "SHZT": "开放赎回",
 * "FHFCZ": "",
 * "FHFCBZ": "",
 * "DTYPE": null,
 * "FHSP": ""
 */
public class HistoryValueVo {
    /**
     * 基金代码
     */
    private String CODE;
    /**
     * 净值日期
     */
    private String FSRQ;
    /**
     * 单位净值
     */
    private String DWJZ;
    /**
     * 累计净值
     */
    private String LJJZ;
    private String SDATE;
    private String ACTUALSYI;
    private String NAVTYPE;
    /**
     * 净值日增长率
     */
    private String JZZZL;
    /**
     * 申购状态
     */
    private String SGZT;
    /**
     * 赎回状态
     */
    private String SHZT;
    /**
     *
     */
    private String FHFCZ;
    private String FHFCBZ;
    private String DTYPE;
    private String FHSP;

    public String getFSRQ() {
        return FSRQ;
    }

    public void setFSRQ(String FSRQ) {
        this.FSRQ = FSRQ;
    }

    public String getDWJZ() {
        return DWJZ;
    }

    public void setDWJZ(String DWJZ) {
        this.DWJZ = DWJZ;
    }

    public String getLJJZ() {
        return LJJZ;
    }

    public void setLJJZ(String LJJZ) {
        this.LJJZ = LJJZ;
    }

    public String getSDATE() {
        return SDATE;
    }

    public void setSDATE(String SDATE) {
        this.SDATE = SDATE;
    }

    public String getACTUALSYI() {
        return ACTUALSYI;
    }

    public void setACTUALSYI(String ACTUALSYI) {
        this.ACTUALSYI = ACTUALSYI;
    }

    public String getNAVTYPE() {
        return NAVTYPE;
    }

    public void setNAVTYPE(String NAVTYPE) {
        this.NAVTYPE = NAVTYPE;
    }

    public String getJZZZL() {
        return JZZZL;
    }

    public void setJZZZL(String JZZZL) {
        this.JZZZL = JZZZL;
    }

    public String getSGZT() {
        return SGZT;
    }

    public void setSGZT(String SGZT) {
        this.SGZT = SGZT;
    }

    public String getSHZT() {
        return SHZT;
    }

    public void setSHZT(String SHZT) {
        this.SHZT = SHZT;
    }

    public String getFHFCZ() {
        return FHFCZ;
    }

    public void setFHFCZ(String FHFCZ) {
        this.FHFCZ = FHFCZ;
    }

    public String getFHFCBZ() {
        return FHFCBZ;
    }

    public void setFHFCBZ(String FHFCBZ) {
        this.FHFCBZ = FHFCBZ;
    }

    public String getDTYPE() {
        return DTYPE;
    }

    public void setDTYPE(String DTYPE) {
        this.DTYPE = DTYPE;
    }

    public String getFHSP() {
        return FHSP;
    }

    public void setFHSP(String FHSP) {
        this.FHSP = FHSP;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    @Override
    public String toString() {
        return "HistoryValueVo{" +
                "CODE='" + CODE + '\'' +
                ", FSRQ='" + FSRQ + '\'' +
                ", DWJZ='" + DWJZ + '\'' +
                ", LJJZ='" + LJJZ + '\'' +
                ", SDATE='" + SDATE + '\'' +
                ", ACTUALSYI='" + ACTUALSYI + '\'' +
                ", NAVTYPE='" + NAVTYPE + '\'' +
                ", JZZZL='" + JZZZL + '\'' +
                ", SGZT='" + SGZT + '\'' +
                ", SHZT='" + SHZT + '\'' +
                ", FHFCZ='" + FHFCZ + '\'' +
                ", FHFCBZ='" + FHFCBZ + '\'' +
                ", DTYPE='" + DTYPE + '\'' +
                ", FHSP='" + FHSP + '\'' +
                '}';
    }
}
