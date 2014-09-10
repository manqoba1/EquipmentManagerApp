/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sfiso.eqm.dto;

 
import com.sifiso.eqm.data.Organisation;
import com.sifiso.eqm.data.User;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class UserDTO {

    private Integer userID;
    private String userName;
    private String userSurname;
    private String userEmaill, organisationName;
    private String userTel;
    private Integer userStatus;
    private int organisationID;
    private List<UserinventoryDTO> userinventoryList;

    public UserDTO(User u) {
        userID = u.getUserID();
        userName = u.getUserName();
        userSurname = u.getUserSurname();
        userEmaill = u.getUserEmaill();
        userTel = u.getUserTel();
        userStatus = u.getUserStatus();
        Organisation w = u.getOrganisation();
        organisationName = w.getOrganisationName();
        organisationID = w.getOrganisationID();

    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

    public String getUserEmaill() {
        return userEmaill;
    }

    public void setUserEmaill(String userEmaill) {
        this.userEmaill = userEmaill;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public int getOrganisationID() {
        return organisationID;
    }

    public void setOrganisationID(int organisationID) {
        this.organisationID = organisationID;
    }

    public List<UserinventoryDTO> getUserinventoryList() {
        return userinventoryList;
    }

    public void setUserinventoryList(List<UserinventoryDTO> userinventoryList) {
        this.userinventoryList = userinventoryList;
    }

}
