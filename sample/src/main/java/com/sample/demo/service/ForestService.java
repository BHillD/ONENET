package com.sample.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.sample.demo.mapper.ForestMapper;
import com.sample.demo.model.Fisheries;
import com.sample.demo.model.Forest_atm;
import com.sample.demo.model.Forest_soil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * date: 2019/6/21
 * description: 与渔林有关的相关服务类
 */

@Service
public class ForestService {

    @Autowired
    ForestMapper forestMapper;

    @Autowired
    @Qualifier("forest")
    String[] forest;


    public void addForestAtm(Forest_atm atm){
        forestMapper.addForestAtm(atm);
    }

    public void addForestSoil(Forest_soil soil){
        forestMapper.addForestSoil(soil);
    }

    public void addFisherise(Fisheries fisheries){
        forestMapper.addFisherise(fisheries);
    }

    public void addDate(String date){
        forestMapper.addDate(date);
    }

    public BigDecimal getStandard(String row){
        return forestMapper.getStandard(row);
    }

    public void updateStandard(String name, String value){
        forestMapper.updateStandard(name, value);
    }

    public JSONObject getData(){
        JSONObject obj = new JSONObject();
        obj.put("for_atm", forestMapper.getForest_atm());
        obj.put("for_soil", forestMapper.getForest_soil());
        obj.put("fish", forestMapper.getFish());
        return obj;
    }

    public List<String> getHistory(){
        return forestMapper.getData();
    }

}
