package com.sample.demo.model;


import java.math.BigDecimal;

public class Met_soil {
    private BigDecimal soil_tem;
    private BigDecimal soil_humidity;

    public Met_soil(){}

    public Met_soil(String soil_tem, String soil_humidity) {
        this.soil_tem = new BigDecimal(soil_tem);
        this.soil_humidity = new BigDecimal(soil_humidity);
    }

    public BigDecimal getSoil_tem() {
        return soil_tem;
    }

    public void setSoil_tem(BigDecimal soil_tem) {
        this.soil_tem = soil_tem;
    }

    public BigDecimal getSoil_humidity() {
        return soil_humidity;
    }

    public void setSoil_humidity(BigDecimal soil_humidity) {
        this.soil_humidity = soil_humidity;
    }
}
