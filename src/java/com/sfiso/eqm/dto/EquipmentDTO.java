/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sfiso.eqm.dto;

import com.sifiso.eqm.data.Equipment;
import com.sifiso.eqm.data.Organisation;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class EquipmentDTO {

    private Integer equipmentID;
    private String equipmentName, organisationName;
    private List<EqupmanageDTO> equpmanageList;
    private int organisationID;
    private List<InventoryDTO> inventoryList;

    public EquipmentDTO(Equipment e) {
        equipmentID = e.getEquipmentID();
        equipmentName = e.getEquipmentName();
        Organisation o = e.getOrganisation();
        organisationID = o.getOrganisationID();
        organisationName = o.getOrganisationName();
    }

    public Integer getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(Integer equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
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

    public List<InventoryDTO> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<InventoryDTO> inventoryList) {
        this.inventoryList = inventoryList;
    }

}
