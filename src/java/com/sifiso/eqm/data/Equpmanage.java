/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.eqm.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "equpmanage")
@NamedQueries({
    @NamedQuery(name = "Equpmanage.findAll", query = "SELECT e FROM Equpmanage e"),
    @NamedQuery(name = "Equpmanage.findByManagerID",
            query = "SELECT e FROM Equpmanage e WHERE e.equipmentmanager.equipmentManagerID = :managerID"),
    @NamedQuery(name = "Equpmanage.findByEqupManageID", query = "SELECT e FROM Equpmanage e WHERE e.equpManageID = :equpManageID"),
    @NamedQuery(name = "Equpmanage.findByAssignedDate",
            query = "SELECT e FROM Equpmanage e WHERE e.assignedDate = :assignedDate"),
    @NamedQuery(name = "Equpmanage.findByPasswordAndEmail",
            query = "SELECT e FROM Equpmanage e WHERE e.equipmentmanager.password = :password AND e.equipmentmanager.equipmentManagerEmail = :email")})
public class Equpmanage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "equpManageID")
    private Integer equpManageID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "assignedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assignedDate;
    @JoinColumn(name = "equipmentID", referencedColumnName = "equipmentID")
    @ManyToOne(optional = false)
    private Equipment equipment;
    @JoinColumn(name = "equipmentmanagerID", referencedColumnName = "equipmentManagerID")
    @ManyToOne(optional = false)
    private Equipmentmanager equipmentmanager;

    public Equpmanage() {
    }

    public Equpmanage(Integer equpManageID) {
        this.equpManageID = equpManageID;
    }

    public Equpmanage(Integer equpManageID, Date assignedDate) {
        this.equpManageID = equpManageID;
        this.assignedDate = assignedDate;
    }

    public Integer getEqupManageID() {
        return equpManageID;
    }

    public void setEqupManageID(Integer equpManageID) {
        this.equpManageID = equpManageID;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Equipmentmanager getEquipmentmanager() {
        return equipmentmanager;
    }

    public void setEquipmentmanager(Equipmentmanager equipmentmanager) {
        this.equipmentmanager = equipmentmanager;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equpManageID != null ? equpManageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equpmanage)) {
            return false;
        }
        Equpmanage other = (Equpmanage) object;
        if ((this.equpManageID == null && other.equpManageID != null) || (this.equpManageID != null && !this.equpManageID.equals(other.equpManageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.eqm.data.Equpmanage[ equpManageID=" + equpManageID + " ]";
    }

}
