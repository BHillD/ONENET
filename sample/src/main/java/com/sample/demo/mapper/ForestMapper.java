package com.sample.demo.mapper;

import com.sample.demo.model.*;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ForestMapper {

    void addForestAtm(@Param("atm") Forest_atm atm);

    void addForestSoil(@Param("soil") Forest_soil soil);

    void addFisherise(@Param("fisheries") Fisheries fisheries);

    void addDate(@Param("date") String date);

    BigDecimal getStandard(@Param("row") String row);

    void updateStandard(@Param("name") String name, @Param("value") String value);

    Forest_atm getForest_atm();

    Forest_soil getForest_soil();

    Fisheries getFish();

    List<String> getData();


}
