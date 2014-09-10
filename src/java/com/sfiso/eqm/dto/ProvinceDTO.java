/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sfiso.eqm.dto;

 
import com.sifiso.eqm.data.Province;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class ProvinceDTO {

    private Integer provinceID;
    private String provinceName;
    private List<CityDTO> cityList;

    public ProvinceDTO(Province p) {
        provinceID = p.getProvinceID();
        provinceName = p.getName();
    }

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public List<CityDTO> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityDTO> cityList) {
        this.cityList = cityList;
    }

}
