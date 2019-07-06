package com.sample.demo.model;


import java.math.BigDecimal;

public class Met_atm {

    private BigDecimal o2;
    private BigDecimal atm_tem;
    private BigDecimal atm_humidity;
    private BigDecimal atm_pre;

    public Met_atm(){}

    public Met_atm(String o2, String atm_tem, String atm_humidity, String atm_pre) {
        this.o2 = new BigDecimal(o2);
        this.atm_tem = new BigDecimal(atm_tem);
        this.atm_humidity = new BigDecimal(atm_humidity);
        this.atm_pre = new BigDecimal(atm_pre);
    }


    public BigDecimal getO2() {
        return o2;
    }

    public void setO2(BigDecimal o2) {
        this.o2 = o2;
    }

    public BigDecimal getAtm_tem() {
        return atm_tem;
    }

    public void setAtm_tem(BigDecimal atm_tem) {
        this.atm_tem = atm_tem;
    }

    public BigDecimal getAtm_humidity() {
        return atm_humidity;
    }

    public void setAtm_humidity(BigDecimal atm_humidity) {
        this.atm_humidity = atm_humidity;
    }

    public BigDecimal getAtm_pre() {
        return atm_pre;
    }

    public void setAtm_pre(BigDecimal atm_pre) {
        this.atm_pre = atm_pre;
    }
}
