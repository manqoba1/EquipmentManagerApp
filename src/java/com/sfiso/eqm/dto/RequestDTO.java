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

    private int requestType;
    private String name;

    public static final int ADD_EQUIPMENT = 1;
    public static final int ADD_INVENTORY = 2;
    public static final int ASSIGN_INVENTORY_TO_USER = 3;
    public static final int GET_EQUIPMENT = 4;
    public static final int GET_INVENTORY = 5;
    public static final int GET_USER_INVENTORY = 5;

    private EquipmentDTO equipmentDTO;
    private InventoryDTO inventoryDTO;
    private UserinventoryDTO userinventoryDTO;

    private List<EquipmentDTO> equipmentDTOs;
    private List<InventoryDTO> inventoryDTOs;
    private List<UserinventoryDTO> userinventoryDTOs;

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

}
