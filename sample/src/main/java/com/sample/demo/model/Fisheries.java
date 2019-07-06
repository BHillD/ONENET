package com.sample.demo.model;


import java.math.BigDecimal;



public class Fisheries {
    private BigDecimal water_tem;
    private BigDecimal turbidity;


    public Fisheries(){}

    public Fisheries(String water_tem, String turbidity) {
        this.water_tem = new BigDecimal(water_tem);
        this.turbidity = new BigDecimal(turbidity);
    }

    public BigDecimal getWater_tem() {
        return water_tem;
    }

    public void setWater_tem(BigDecimal water_tem) {
        this.water_tem = water_tem;
    }

    public BigDecimal getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(BigDecimal turbidity) {
        this.turbidity = turbidity;
    }
}
