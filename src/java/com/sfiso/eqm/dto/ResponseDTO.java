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
    public static final int OK = 0;
    public static final int SERVER_ERROR = 100;
    public static final int DATABASE_ERROR = 101;
    public static final int DATA_NOT_FOUND = 102;
    public static final int UNKNOWN_REQUEST = 103;

    private EquipmentDTO equipmentDTO;
    private InventoryDTO inventoryDTO;
    private UserinventoryDTO userinventoryDTO;
    private UserDTO userDTO;

    private List<EquipmentDTO> equipmentDTOs;
    private List<InventoryDTO> inventoryDTOs;
    private List<UserinventoryDTO> userinventoryDTOs;
    private List<UserDTO> userDTOs;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
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
