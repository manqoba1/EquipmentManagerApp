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
public class ResponseDTO {

    private int statusCode;
    private String message;
    private String sessionID;
    public static final int OK = 0;
    public static final int SERVER_ERROR = 100;
    public static final int DATABASE_ERROR = 101;
    public static final int DATA_NOT_FOUND = 102;
    public static final int UNKNOWN_REQUEST = 103;

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

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public List<UserDTO> getUserDTOs() {
        return userDTOs;
    }

    public void setUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
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

}
