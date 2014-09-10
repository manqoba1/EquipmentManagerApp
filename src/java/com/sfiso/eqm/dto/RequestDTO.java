/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sfiso.eqm.dto;

import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class RequestDTO {

    private int requestType, userID, equipmentID, organisationID;
    private String name;

    public static final int ADD_EQUIPMENT = 1;
    public static final int ADD_INVENTORY = 2;
    public static final int ASSIGN_INVENTORY_TO_USER = 3;
    public static final int GET_EQUIPMENT = 4;
    public static final int GET_INVENTORY = 5;
    public static final int GET_USER_INVENTORY = 6;
    public static final int ADD_USER = 7;
    public static final int ADD_ORGANISATION = 8;
    public static final int ASSIGN_EQUIPMENT_TO_MANANGER = 9;
    public static final int GET_USER_BY_ORGANISATION_ID = 10;
    public static final int ADD_EQUIPMENT_MANAGER = 11;
    public static final int GET_INVENTORY_BY_USER_ID = 12;
    public static final int GET_INVENTORY_BY_EQUIPMENT_ID = 13;
    //  public static final int GET_INVENTORY_BY_USER_ID = 14;

    private EquipmentDTO equipmentDTO;
    private InventoryDTO inventoryDTO;
    private UserinventoryDTO userinventoryDTO;
    private UserDTO userDTO;
    private ConsultantDTO consultantDTO;
    private CityDTO cityDTO;
    private EquipmentmanagerDTO equipmentmanagerDTO;
    private EqupmanageDTO equpmanageDTO;
    private OrganisationDTO organisationDTO;
    private ConsultantorganisationDTO consultantorganisationDTO;
    private ProvinceDTO provinceDTO;

    private List<EquipmentDTO> equipmentDTOs;
    private List<InventoryDTO> inventoryDTOs;
    private List<UserinventoryDTO> userinventoryDTOs;
    private List<UserDTO> userDTOs;
    private List<ConsultantDTO> consultantDTOs;
    private List<CityDTO> cityDTOs;
    private List<EquipmentmanagerDTO> equipmentmanagerDTOs;
    private List<EqupmanageDTO> equpmanageDTOs;
    private List<OrganisationDTO> organisationDTOs;
    private List<ConsultantorganisationDTO> consultantorganisationDTOs;
    private List<ProvinceDTO> provinceDTOs;

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }

    public int getOrganisationID() {
        return organisationID;
    }

    public void setOrganisationID(int organisationID) {
        this.organisationID = organisationID;
    }

    public EquipmentDTO getEquipmentDTO() {
        return equipmentDTO;
    }

    public void setEquipmentDTO(EquipmentDTO equipmentDTO) {
        this.equipmentDTO = equipmentDTO;
    }

    public InventoryDTO getInventoryDTO() {
        return inventoryDTO;
    }

    public void setInventoryDTO(InventoryDTO inventoryDTO) {
        this.inventoryDTO = inventoryDTO;
    }

    public UserinventoryDTO getUserinventoryDTO() {
        return userinventoryDTO;
    }

    public void setUserinventoryDTO(UserinventoryDTO userinventoryDTO) {
        this.userinventoryDTO = userinventoryDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public ConsultantDTO getConsultantDTO() {
        return consultantDTO;
    }

    public void setConsultantDTO(ConsultantDTO consultantDTO) {
        this.consultantDTO = consultantDTO;
    }

    public CityDTO getCityDTO() {
        return cityDTO;
    }

    public void setCityDTO(CityDTO cityDTO) {
        this.cityDTO = cityDTO;
    }

    public EquipmentmanagerDTO getEquipmentmanagerDTO() {
        return equipmentmanagerDTO;
    }

    public void setEquipmentmanagerDTO(EquipmentmanagerDTO equipmentmanagerDTO) {
        this.equipmentmanagerDTO = equipmentmanagerDTO;
    }

    public EqupmanageDTO getEqupmanageDTO() {
        return equpmanageDTO;
    }

    public void setEqupmanageDTO(EqupmanageDTO equpmanageDTO) {
        this.equpmanageDTO = equpmanageDTO;
    }

    public OrganisationDTO getOrganisationDTO() {
        return organisationDTO;
    }

    public void setOrganisationDTO(OrganisationDTO organisationDTO) {
        this.organisationDTO = organisationDTO;
    }

    public ConsultantorganisationDTO getConsultantorganisationDTO() {
        return consultantorganisationDTO;
    }

    public void setConsultantorganisationDTO(ConsultantorganisationDTO consultantorganisationDTO) {
        this.consultantorganisationDTO = consultantorganisationDTO;
    }

    public ProvinceDTO getProvinceDTO() {
        return provinceDTO;
    }

    public void setProvinceDTO(ProvinceDTO provinceDTO) {
        this.provinceDTO = provinceDTO;
    }

    public List<EquipmentDTO> getEquipmentDTOs() {
        return equipmentDTOs;
    }

    public void setEquipmentDTOs(List<EquipmentDTO> equipmentDTOs) {
        this.equipmentDTOs = equipmentDTOs;
    }

    public List<InventoryDTO> getInventoryDTOs() {
        return inventoryDTOs;
    }

    public void setInventoryDTOs(List<InventoryDTO> inventoryDTOs) {
        this.inventoryDTOs = inventoryDTOs;
    }

    public List<UserinventoryDTO> getUserinventoryDTOs() {
        return userinventoryDTOs;
    }

    public void setUserinventoryDTOs(List<UserinventoryDTO> userinventoryDTOs) {
        this.userinventoryDTOs = userinventoryDTOs;
    }

    public List<UserDTO> getUserDTOs() {
        return userDTOs;
    }

    public void setUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
    }

    public List<ConsultantDTO> getConsultantDTOs() {
        return consultantDTOs;
    }

    public void setConsultantDTOs(List<ConsultantDTO> consultantDTOs) {
        this.consultantDTOs = consultantDTOs;
    }

    public List<CityDTO> getCityDTOs() {
        return cityDTOs;
    }

    public void setCityDTOs(List<CityDTO> cityDTOs) {
        this.cityDTOs = cityDTOs;
    }

    public List<EquipmentmanagerDTO> getEquipmentmanagerDTOs() {
        return equipmentmanagerDTOs;
    }

    public void setEquipmentmanagerDTOs(List<EquipmentmanagerDTO> equipmentmanagerDTOs) {
        this.equipmentmanagerDTOs = equipmentmanagerDTOs;
    }

    public List<EqupmanageDTO> getEqupmanageDTOs() {
        return equpmanageDTOs;
    }

    public void setEqupmanageDTOs(List<EqupmanageDTO> equpmanageDTOs) {
        this.equpmanageDTOs = equpmanageDTOs;
    }

    public List<OrganisationDTO> getOrganisationDTOs() {
        return organisationDTOs;
    }

    public void setOrganisationDTOs(List<OrganisationDTO> organisationDTOs) {
        this.organisationDTOs = organisationDTOs;
    }

    public List<ConsultantorganisationDTO> getConsultantorganisationDTOs() {
        return consultantorganisationDTOs;
    }

    public void setConsultantorganisationDTOs(List<ConsultantorganisationDTO> consultantorganisationDTOs) {
        this.consultantorganisationDTOs = consultantorganisationDTOs;
    }

    public List<ProvinceDTO> getProvinceDTOs() {
        return provinceDTOs;
    }

    public void setProvinceDTOs(List<ProvinceDTO> provinceDTOs) {
        this.provinceDTOs = provinceDTOs;
    }

}
