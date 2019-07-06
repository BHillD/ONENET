package com.sample.demo.mapper;

import com.sample.demo.model.*;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface MeteorologicalMapper {


    void addMetSoil(@Param("soil") Met_soil soil);

    void addMetAtm(@Param("atm") Met_atm atm);

    void addMetEnviron(@Param("environ") Met_envir environ );

    void addMetDate(@Param("date") String date);

    Met_atm getMetAtm();

    Met_envir getMetEnvir();

    Met_soil getMetSoil();

    BigDecimal getStandard(@Param("row") String row);

    void updateStandard(@Param("name") String name,@Param("value") String value);

    List<String> getData();

    List<String> getTime();
}
