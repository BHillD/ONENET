package com.sample.demo.model;

import java.math.BigDecimal;

public class Met_envir {

    private BigDecimal illum;
    private BigDecimal rain;
    private Integer wind_dir;
    private BigDecimal wind_sp;

    public Met_envir(){}

    public Met_envir(String illum, String rain, String wind_dir, String wind_sp) {
        this.illum = new BigDecimal(illum);
        this.rain = new BigDecimal(rain);
        this.wind_dir = Integer.parseInt(wind_dir);
        this.wind_sp = new BigDecimal(wind_sp);
    }

    public BigDecimal getIllum() {
        return illum;
    }

    public void setIllum(BigDecimal illum) {
        this.illum = illum;
    }

    public BigDecimal getRain() {
        return rain;
    }

    public void setRain(BigDecimal rain) {
        this.rain = rain;
    }

    public Integer getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(Integer wind_dir) {
        this.wind_dir = wind_dir;
    }

    public BigDecimal getWind_sp() {
        return wind_sp;
    }

    public void setWind_sp(BigDecimal wind_sp) {
        this.wind_sp = wind_sp;
    }
}
