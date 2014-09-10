/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sfiso.eqm.dto;

import com.sifiso.eqm.data.Equipmentmanager;
import com.sifiso.eqm.data.Organisation;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class EquipmentmanagerDTO {

    private Integer equipmentManagerID;
    private String equipmentManagerName;
    private String equipmentManagerSurname;
    private String equipmentManagerEmail;
    private String equipmentManagerTel;
    private String equipmentManagerAddress, organisationName;
    private String managerImage;
    private String password;
    private List<EqupmanageDTO> equpmanageList;
    private int organisationID;

    public EquipmentmanagerDTO(Equipmentmanager e) {
        equipmentManagerID = e.getEquipmentManagerID();
        equipmentManagerName = e.getEquipmentManagerName();
        equipmentManagerSurname = e.getEquipmentManagerSurname();
        equipmentManagerEmail = e.getEquipmentManagerEmail();
        equipmentManagerTel = e.getEquipmentManagerTel();
        equipmentManagerAddress = e.getEquipmentManagerAddress();
        managerImage = e.getManagerImage();
        password = e.getPassword();
        Organisation o = e.getOrganisation();
        organisationID = o.getOrganisationID();
        organisationName = o.getOrganisationName();
    }

    public Integer getEquipmentManagerID() {
        return equipmentManagerID;
    }

    public void setEquipmentManagerID(Integer equipmentManagerID) {
        this.equipmentManagerID = equipmentManagerID;
    }

    public String getManagerImage() {
        return managerImage;
    }

    public void setManagerImage(String managerImage) {
        this.managerImage = managerImage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEquipmentManagerName() {
        return equipmentManagerName;
    }

    public void setEquipmentManagerName(String equipmentManagerName) {
        this.equipmentManagerName = equipmentManagerName;
    }

    public String getEquipmentManagerSurname() {
        return equipmentManagerSurname;
    }

    public void setEquipmentManagerSurname(String equipmentManagerSurname) {
        this.equipmentManagerSurname = equipmentManagerSurname;
    }

    public String getEquipmentManagerEmail() {
        return equipmentManagerEmail;
    }

    public void setEquipmentManagerEmail(String equipmentManagerEmail) {
        this.equipmentManagerEmail = equipmentManagerEmail;
    }

    public String getEquipmentManagerTel() {
        return equipmentManagerTel;
    }

    public void setEquipmentManagerTel(String equipmentManagerTel) {
        this.equipmentManagerTel = equipmentManagerTel;
    }

    public String getEquipmentManagerAddress() {
        return equipmentManagerAddress;
    }

    public void setEquipmentManagerAddress(String equipmentManagerAddress) {
        this.equipmentManagerAddress = equipmentManagerAddress;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public List<EqupmanageDTO> getEqupmanageList() {
        return equpmanageList;
    }

    public void setEqupmanageList(List<EqupmanageDTO> equpmanageList) {
        this.equpmanageList = equpmanageList;
    }

    public int getOrganisationID() {
        return organisationID;
    }

    public void setOrganisationID(int organisationID) {
        this.organisationID = organisationID;
    }

}
