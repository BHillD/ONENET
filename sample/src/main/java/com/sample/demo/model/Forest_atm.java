package com.sample.demo.model;

import java.math.BigDecimal;

public class Forest_atm {
    private BigDecimal co2;
    private BigDecimal atm_tem;
    private BigDecimal smoke;
    private BigDecimal atm_humidity;

    public Forest_atm(){}

    public Forest_atm(String co2, String tem, String smoke, String humidity) {
        this.co2 = new BigDecimal(co2);
        this.atm_tem = new BigDecimal(tem);
        this.smoke = new BigDecimal(smoke);
        this.atm_humidity = new BigDecimal(humidity);
    }


    public BigDecimal getSmoke() {
        return smoke;
    }

    public void setSmoke(BigDecimal smoke) {
        this.smoke = smoke;
    }

    public BigDecimal getCo2() {
        return co2;
    }

    public void setCo2(BigDecimal co2) {
        this.co2 = co2;
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
}
