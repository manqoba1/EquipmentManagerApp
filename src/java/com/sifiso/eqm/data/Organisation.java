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
@Table(name = "organisation")
@NamedQueries({
    @NamedQuery(name = "Organisation.findAll", query = "SELECT o FROM Organisation o"),
    @NamedQuery(name = "Organisation.findByOrganisationID", query = "SELECT o FROM Organisation o WHERE o.organisationID = :organisationID"),
    @NamedQuery(name = "Organisation.findByOrganisationName", query = "SELECT o FROM Organisation o WHERE o.organisationName = :organisationName"),
    @NamedQuery(name = "Organisation.findByContactname", query = "SELECT o FROM Organisation o WHERE o.contactname = :contactname"),
    @NamedQuery(name = "Organisation.findByOrganisationAddress", query = "SELECT o FROM Organisation o WHERE o.organisationAddress = :organisationAddress"),
    @NamedQuery(name = "Organisation.findByLatitude", query = "SELECT o FROM Organisation o WHERE o.latitude = :latitude"),
    @NamedQuery(name = "Organisation.findByLongitude", query = "SELECT o FROM Organisation o WHERE o.longitude = :longitude")})
public class Organisation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "organisationID")
    private Integer organisationID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "organisationName")
    private String organisationName;
    @Size(max = 255)
    @Column(name = "contactname")
    private String contactname;
    @Size(max = 255)
    @Column(name = "organisationAddress")
    private String organisationAddress;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organisation")
    private List<Equipmentmanager> equipmentmanagerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organisation")
    private List<Equipment> equipmentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organisation")
    private List<Consultantorganisation> consultantorganisationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organisation")
    private List<User> userList;

    public Organisation() {
    }

    public Organisation(Integer organisationID) {
        this.organisationID = organisationID;
    }

    public Organisation(Integer organisationID, String organisationName) {
        this.organisationID = organisationID;
        this.organisationName = organisationName;
    }

    public Integer getOrganisationID() {
        return organisationID;
    }

    public void setOrganisationID(Integer organisationID) {
        this.organisationID = organisationID;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getOrganisationAddress() {
        return organisationAddress;
    }

    public void setOrganisationAddress(String organisationAddress) {
        this.organisationAddress = organisationAddress;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<Equipmentmanager> getEquipmentmanagerList() {
        return equipmentmanagerList;
    }

    public void setEquipmentmanagerList(List<Equipmentmanager> equipmentmanagerList) {
        this.equipmentmanagerList = equipmentmanagerList;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public List<Consultantorganisation> getConsultantorganisationList() {
        return consultantorganisationList;
    }

    public void setConsultantorganisationList(List<Consultantorganisation> consultantorganisationList) {
        this.consultantorganisationList = consultantorganisationList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (organisationID != null ? organisationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organisation)) {
            return false;
        }
        Organisation other = (Organisation) object;
        if ((this.organisationID == null && other.organisationID != null) || (this.organisationID != null && !this.organisationID.equals(other.organisationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.eqm.data.Organisation[ organisationID=" + organisationID + " ]";
    }

}
