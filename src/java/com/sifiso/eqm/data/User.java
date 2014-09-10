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
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
     @NamedQuery(name = "User.findUsersByOrganisationID", 
             query = "SELECT u FROM User u WHERE u.organisation.organisationID = :organisationID"),
    @NamedQuery(name = "User.findByUserID", query = "SELECT u FROM User u WHERE u.userID = :userID"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByUserSurname", query = "SELECT u FROM User u WHERE u.userSurname = :userSurname"),
    @NamedQuery(name = "User.findByUserEmaill", query = "SELECT u FROM User u WHERE u.userEmaill = :userEmaill"),
    @NamedQuery(name = "User.findByUserTel", query = "SELECT u FROM User u WHERE u.userTel = :userTel"),
    @NamedQuery(name = "User.findByUserStatus", query = "SELECT u FROM User u WHERE u.userStatus = :userStatus")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userID")
    private Integer userID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userName")
    private String userName;
    @Size(max = 255)
    @Column(name = "userSurname")
    private String userSurname;
    @Size(max = 255)
    @Column(name = "userEmaill")
    private String userEmaill;
    @Size(max = 15)
    @Column(name = "userTel")
    private String userTel;
    @Column(name = "userStatus")
    private Integer userStatus;
    @JoinColumn(name = "organisationID", referencedColumnName = "organisationID")
    @ManyToOne(optional = false)
    private Organisation organisation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Userinventory> userinventoryList;

    public User() {
    }

    public User(Integer userID) {
        this.userID = userID;
    }

    public User(Integer userID, String userName) {
        this.userID = userID;
        this.userName = userName;
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

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
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
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.eqm.data.User[ userID=" + userID + " ]";
    }
    
}
