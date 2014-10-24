/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sfiso.eqm.dto;

import com.sifiso.eqm.data.Equipment;
import com.sifiso.eqm.data.Equipmentmanager;
import com.sifiso.eqm.data.Equpmanage;
import com.sifiso.eqm.data.Organisation;

/**
 *
 * @author CodeTribe1
 */
public class EqupmanageDTO {

    private Integer equpManageID;
    private int equipmentID;
    private long assignedDate;
    private String equipmentImage, equipmentName, equipmentmanagerName, equipmentmanagerSurname, organisationName;

    private int equipmentmanagerID, organisationID;

    public EqupmanageDTO(Equpmanage em) {
        equpManageID = em.getEqupManageID();
        assignedDate = em.getAssignedDate().getTime();
        Equipment e = em.getEquipment();
        equipmentID = e.getEquipmentID();
        equipmentName = e.getEquipmentName();
        equipmentImage = e.getEquipmentImage();
        Equipmentmanager eqm = em.getEquipmentmanager();
        equipmentmanagerID = eqm.getEquipmentManagerID();
        equipmentmanagerName = eqm.getEquipmentManagerName();
        equipmentmanagerSurname = eqm.getEquipmentManagerSurname();
        Organisation o = eqm.getOrganisation();
        organisationID = o.getOrganisationID();
        organisationName = o.getOrganisationName();

    }

    public Integer getEqupManageID() {
        return equpManageID;
    }

    public void setEqupManageID(Integer equpManageID) {
        this.equpManageID = equpManageID;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public int getOrganisationID() {
        return organisationID;
    }

    public void setOrganisationID(int organisationID) {
        this.organisationID = organisationID;
    }

    public long getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(long assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getEquipmentImage() {
        return equipmentImage;
    }

    public void setEquipmentImage(String equipmentImage) {
        this.equipmentImage = equipmentImage;
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
