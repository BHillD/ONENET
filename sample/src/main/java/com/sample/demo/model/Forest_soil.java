package com.sample.demo.model;

import java.math.BigDecimal;

public class Forest_soil {
    private BigDecimal soil_nity;
    private BigDecimal soil_tem;
    private BigDecimal soil_hum;
    private BigDecimal conductivity;

    public Forest_soil(){}

    public Forest_soil(String nity, String tem, String hum, String conduct) {
        this.soil_nity = new BigDecimal(nity);
        this.soil_tem = new BigDecimal(tem);
        this.soil_hum = new BigDecimal(hum);
        this.conductivity = new BigDecimal(conduct);
    }

    public BigDecimal getSoil_nity() {
        return soil_nity;
    }

    public void setSoil_nity(BigDecimal soil_nity) {
        this.soil_nity = soil_nity;
    }

    public BigDecimal getSoil_tem() {
        return soil_tem;
    }

    public void setSoil_tem(BigDecimal soil_tem) {
        this.soil_tem = soil_tem;
    }

    public BigDecimal getSoil_hum() {
        return soil_hum;
    }

    public void setSoil_hum(BigDecimal soil_hum) {
        this.soil_hum = soil_hum;
    }

    public BigDecimal getConductivity() {
        return conductivity;
    }

    public void setConductivity(BigDecimal conductivity) {
        this.conductivity = conductivity;
    }
}
