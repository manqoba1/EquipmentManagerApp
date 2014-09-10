/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sfiso.eqm.dto;

import com.sifiso.eqm.data.Inventory;
import com.sifiso.eqm.data.User;
import com.sifiso.eqm.data.Userinventory;

/**
 *
 * @author CodeTribe1
 */
public class UserinventoryDTO {

    private Integer userInventoryID;
    private int inventoryID;
    private int userID;

    public UserinventoryDTO(Userinventory ui) {
        userInventoryID = ui.getUserInventoryID();
        User u = ui.getUser();
        Inventory i = ui.getInventory();
        inventoryID = i.getInventoryID();
        userID = u.getUserID();
    }

    public Integer getUserInventoryID() {
        return userInventoryID;
    }

    public void setUserInventoryID(Integer userInventoryID) {
        this.userInventoryID = userInventoryID;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
