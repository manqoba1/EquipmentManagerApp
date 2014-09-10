/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.eqm.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "equipment")
@NamedQueries({
    @NamedQuery(name = "Equipment.findAll", query = "SELECT e FROM Equipment e"),
    @NamedQuery(name = "Equipment.findByEquipmentID", query = "SELECT e FROM Equipment e WHERE e.equipmentID = :equipmentID"),
    @NamedQuery(name = "Equipment.findByEquipmentName", query = "SELECT e FROM Equipment e WHERE e.equipmentName = :equipmentName")})
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "equipmentID")
    private Integer equipmentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "equipmentName")
    private String equipmentName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipment")
    private List<Equpmanage> equpmanageList;
    @JoinColumn(name = "organisationID", referencedColumnName = "organisationID")
    @ManyToOne(optional = false)
    private Organisation organisation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipment")
    private List<Inventory> inventoryList;

    public Equipment() {
    }

    public Equipment(Integer equipmentID) {
        this.equipmentID = equipmentID;
    }

    public Equipment(Integer equipmentID, String equipmentName) {
        this.equipmentID = equipmentID;
        this.equipmentName = equipmentName;
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

    public List<Equpmanage> getEqupmanageList() {
        return equpmanageList;
    }

    public void setEqupmanageList(List<Equpmanage> equpmanageList) {
        this.equpmanageList = equpmanageList;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipmentID != null ? equipmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipment)) {
            return false;
        }
        Equipment other = (Equipment) object;
        if ((this.equipmentID == null && other.equipmentID != null) || (this.equipmentID != null && !this.equipmentID.equals(other.equipmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.eqm.data.Equipment[ equipmentID=" + equipmentID + " ]";
    }

}
