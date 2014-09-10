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
@Table(name = "inventory")
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i"),
    @NamedQuery(name = "Inventory.findByInventoryID", query = "SELECT i FROM Inventory i WHERE i.inventoryID = :inventoryID"),
    @NamedQuery(name = "Inventory.findByInventoryName", query = "SELECT i FROM Inventory i WHERE i.inventoryName = :inventoryName"),
    @NamedQuery(name = "Inventory.findByInventoryModel", query = "SELECT i FROM Inventory i WHERE i.inventoryModel = :inventoryModel"),
    @NamedQuery(name = "Inventory.findByInventorySerialNo", query = "SELECT i FROM Inventory i WHERE i.inventorySerialNo = :inventorySerialNo")})
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inventoryID")
    private Integer inventoryID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "inventoryName")
    private String inventoryName;
    @Size(max = 255)
    @Column(name = "inventoryModel")
    private String inventoryModel;
    @Size(max = 45)
    @Column(name = "inventorySerialNo")
    private String inventorySerialNo;
    @JoinColumn(name = "equipmentID", referencedColumnName = "equipmentID")
    @ManyToOne(optional = false)
    private Equipment equipment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventory")
    private List<Userinventory> userinventoryList;

    public Inventory() {
    }

    public Inventory(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Inventory(Integer inventoryID, String inventoryName) {
        this.inventoryID = inventoryID;
        this.inventoryName = inventoryName;
    }

    public Integer getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getInventoryModel() {
        return inventoryModel;
    }

    public void setInventoryModel(String inventoryModel) {
        this.inventoryModel = inventoryModel;
    }

    public String getInventorySerialNo() {
        return inventorySerialNo;
    }

    public void setInventorySerialNo(String inventorySerialNo) {
        this.inventorySerialNo = inventorySerialNo;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public List<Userinventory> getUserinventoryList() {
        return userinventoryList;
    }

    public void setUserinventoryList(List<Userinventory> userinventoryList) {
        this.userinventoryList = userinventoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventoryID != null ? inventoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.inventoryID == null && other.inventoryID != null) || (this.inventoryID != null && !this.inventoryID.equals(other.inventoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.eqm.data.Inventory[ inventoryID=" + inventoryID + " ]";
    }

}
