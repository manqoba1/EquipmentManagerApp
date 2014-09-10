/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sfiso.eqm.dto;

import com.sifiso.eqm.data.Equipment;
import com.sifiso.eqm.data.Equipmentmanager;
import com.sifiso.eqm.data.Equpmanage;

/**
 *
 * @author CodeTribe1
 */
public class EqupmanageDTO {

    private Integer equpManageID;
    private int equipmentID;
    private String equipmentName, equipmentmanagerName, equipmentmanagerSurname;
    private int equipmentmanagerID;

    public EqupmanageDTO(Equpmanage em) {
        equpManageID = em.getEqupManageID();
        Equipment e = em.getEquipment();
        equipmentID = e.getEquipmentID();
        equipmentName = e.getEquipmentName();
        Equipmentmanager eqm = em.getEquipmentmanager();
        equipmentmanagerID = eqm.getEquipmentManagerID();
        equipmentmanagerName = eqm.getEquipmentManagerName();
        equipmentmanagerSurname = eqm.getEquipmentManagerSurname();
    }

    public Integer getEqupManageID() {
        return equpManageID;
    }

    public void setEqupManageID(Integer equpManageID) {
        this.equpManageID = equpManageID;
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentmanagerName() {
        return equipmentmanagerName;
    }

    public void setEquipmentmanagerName(String equipmentmanagerName) {
        this.equipmentmanagerName = equipmentmanagerName;
    }

    public String getEquipmentmanagerSurname() {
        return equipmentmanagerSurname;
    }

    public void setEquipmentmanagerSurname(String equipmentmanagerSurname) {
        this.equipmentmanagerSurname = equipmentmanagerSurname;
    }

    public int getEquipmentmanagerID() {
        return equipmentmanagerID;
    }

    public void setEquipmentmanagerID(int equipmentmanagerID) {
        this.equipmentmanagerID = equipmentmanagerID;
    }

}
