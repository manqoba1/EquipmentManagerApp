/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sfiso.eqm.dto;

 
import com.sifiso.eqm.data.Organisation;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class OrganisationDTO {

    private Integer organisationID;
    private String organisationName;
    private String contactname;
    private String organisationAddress;
    private Double latitude;
    private Double longitude;
    private List<EquipmentmanagerDTO> equipmentmanagerList;
    private List<EquipmentDTO> equipmentList;
    private List<ConsultantorganisationDTO> consultantorganisationList;
    private List<UserDTO> userList;

    public OrganisationDTO(Organisation o) {
        organisationID = o.getOrganisationID();
        organisationName = o.getContactname();
        organisationAddress = o.getOrganisationAddress();
        contactname = o.getContactname();
        latitude = o.getLatitude();
        longitude = o.getLongitude();

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

    public List<EquipmentmanagerDTO> getEquipmentmanagerList() {
        return equipmentmanagerList;
    }

    public void setEquipmentmanagerList(List<EquipmentmanagerDTO> equipmentmanagerList) {
        this.equipmentmanagerList = equipmentmanagerList;
    }

    public List<EquipmentDTO> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<EquipmentDTO> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public List<ConsultantorganisationDTO> getConsultantorganisationList() {
        return consultantorganisationList;
    }

    public void setConsultantorganisationList(List<ConsultantorganisationDTO> consultantorganisationList) {
        this.consultantorganisationList = consultantorganisationList;
    }

    public List<UserDTO> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDTO> userList) {
        this.userList = userList;
    }

}
