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
    private String userName;
    private String userSurname, userImage, inventoryImage, inventoryName, inventoryModel, inventorySerialNo;
    private Integer userStatus;
    private int userID;

    public UserinventoryDTO(Userinventory ui) {
        userInventoryID = ui.getUserInventoryID();
        User u = ui.getUser();
        userID = u.getUserID();
        userName = u.getUserName();
        userSurname = u.getUserSurname();
        userImage = u.getUserImage();
        userStatus = u.getUserStatus();
        Inventory i = ui.getInventory();
        inventoryID = i.getInventoryID();
        inventoryImage = i.getInventoryImage();
        inventoryName = i.getInventoryName();
        inventoryModel = i.getInventoryModel();
        inventorySerialNo = i.getInventorySerialNo();
    }

    public Integer getUserInventoryID() {
        return userInventoryID;
    }

    public void setUserInventoryID(Integer userInventoryID) {
        this.userInventoryID = userInventoryID;
    }

    public String getInventorySerialNo() {
        return inventorySerialNo;
    }

    public void setInventorySerialNo(String inventorySerialNo) {
        this.inventorySerialNo = inventorySerialNo;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getInventoryImage() {
        return inventoryImage;
    }

    public void setInventoryImage(String inventoryImage) {
        this.inventoryImage = inventoryImage;
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

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
