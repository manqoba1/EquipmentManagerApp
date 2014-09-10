/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sfiso.eqm.dto;

import com.sifiso.eqm.data.City;
import com.sifiso.eqm.data.Province;


/**
 *
 * @author CodeTribe1
 */
public class CityDTO {

    private Integer cityID;
    private String cityName;
    private int provinceID;

    public CityDTO(City c) {
        cityID = c.getCityID();
        cityName = c.getName();
        Province p = c.getProvince();
        provinceID = p.getProvinceID();
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

}
