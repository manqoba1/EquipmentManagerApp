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
import javax.persistence.Lob;
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
@Table(name = "equipmentmanager")
@NamedQueries({
    @NamedQuery(name = "Equipmentmanager.findAll", query = "SELECT e FROM Equipmentmanager e"),
    @NamedQuery(name = "Equipmentmanager.findByEquipmentManagerID", query = "SELECT e FROM Equipmentmanager e WHERE e.equipmentManagerID = :equipmentManagerID"),
    @NamedQuery(name = "Equipmentmanager.findByEquipmentManagerName", query = "SELECT e FROM Equipmentmanager e WHERE e.equipmentManagerName = :equipmentManagerName"),
    @NamedQuery(name = "Equipmentmanager.findByEquipmentManagerSurname", query = "SELECT e FROM Equipmentmanager e WHERE e.equipmentManagerSurname = :equipmentManagerSurname"),
    @NamedQuery(name = "Equipmentmanager.findByEquipmentManagerEmail", query = "SELECT e FROM Equipmentmanager e WHERE e.equipmentManagerEmail = :equipmentManagerEmail"),
    @NamedQuery(name = "Equipmentmanager.findByEquipmentManagerTel", query = "SELECT e FROM Equipmentmanager e WHERE e.equipmentManagerTel = :equipmentManagerTel"),
    @NamedQuery(name = "Equipmentmanager.findByManagerImage",
            query = "SELECT e FROM Equipmentmanager e WHERE e.managerImage = :managerImage")
})
public class Equipmentmanager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "equipmentManagerID")
    private Integer equipmentManagerID;
    @Size(max = 255)
    @Column(name = "equipmentManagerName")
    private String equipmentManagerName;
    @Size(max = 255)
    @Column(name = "equipmentManagerSurname")
    private String equipmentManagerSurname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "equipmentManagerEmail")
    private String equipmentManagerEmail;
    @Size(max = 15)
    @Column(name = "equipmentManagerTel")
    private String equipmentManagerTel;
    @Lob
    @Size(max = 65535)
    @Column(name = "equipmentManagerAddress")
    private String equipmentManagerAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "managerImage")
    private String managerImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentmanager")
    private List<Equpmanage> equpmanageList;
    @JoinColumn(name = "organisationID", referencedColumnName = "organisationID")
    @ManyToOne(optional = false)
    private Organisation organisation;

    public Equipmentmanager() {
    }

    public Equipmentmanager(Integer equipmentManagerID) {
        this.equipmentManagerID = equipmentManagerID;
    }

    public Equipmentmanager(Integer equipmentManagerID, String equipmentManagerEmail, String managerImage, String password) {
        this.equipmentManagerID = equipmentManagerID;
        this.equipmentManagerEmail = equipmentManagerEmail;
        this.managerImage = managerImage;
        this.password = password;
    }

    public Integer getEquipmentManagerID() {
        return equipmentManagerID;
    }

    public void setEquipmentManagerID(Integer equipmentManagerID) {
        this.equipmentManagerID = equipmentManagerID;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipmentManagerID != null ? equipmentManagerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipmentmanager)) {
            return false;
        }
        Equipmentmanager other = (Equipmentmanager) object;
        if ((this.equipmentManagerID == null && other.equipmentManagerID != null) || (this.equipmentManagerID != null && !this.equipmentManagerID.equals(other.equipmentManagerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.eqm.data.Equipmentmanager[ equipmentManagerID=" + equipmentManagerID + " ]";
    }

}
