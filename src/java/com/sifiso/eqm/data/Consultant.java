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
@Table(name = "consultant")
@NamedQueries({
    @NamedQuery(name = "Consultant.findAll", query = "SELECT c FROM Consultant c"),
    @NamedQuery(name = "Consultant.findByConsultantID", query = "SELECT c FROM Consultant c WHERE c.consultantID = :consultantID"),
    @NamedQuery(name = "Consultant.findByConsultantName", query = "SELECT c FROM Consultant c WHERE c.consultantName = :consultantName"),
    @NamedQuery(name = "Consultant.findByConsultantSurname", query = "SELECT c FROM Consultant c WHERE c.consultantSurname = :consultantSurname"),
    @NamedQuery(name = "Consultant.findByConsultantEmail", query = "SELECT c FROM Consultant c WHERE c.consultantEmail = :consultantEmail"),
    @NamedQuery(name = "Consultant.findByConsultantTel", query = "SELECT c FROM Consultant c WHERE c.consultantTel = :consultantTel")})
public class Consultant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "consultantID")
    private Integer consultantID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "consultantName")
    private String consultantName;
    @Size(max = 255)
    @Column(name = "consultantSurname")
    private String consultantSurname;
    @Size(max = 255)
    @Column(name = "consultantEmail")
    private String consultantEmail;
    @Size(max = 15)
    @Column(name = "consultantTel")
    private String consultantTel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultant")
    private List<Consultantorganisation> consultantorganisationList;

    public Consultant() {
    }

    public Consultant(Integer consultantID) {
        this.consultantID = consultantID;
    }

    public Consultant(Integer consultantID, String consultantName) {
        this.consultantID = consultantID;
        this.consultantName = consultantName;
    }

    public Integer getConsultantID() {
        return consultantID;
    }

    public void setConsultantID(Integer consultantID) {
        this.consultantID = consultantID;
    }

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
    }

    public String getConsultantSurname() {
        return consultantSurname;
    }

    public void setConsultantSurname(String consultantSurname) {
        this.consultantSurname = consultantSurname;
    }

    public String getConsultantEmail() {
        return consultantEmail;
    }

    public void setConsultantEmail(String consultantEmail) {
        this.consultantEmail = consultantEmail;
    }

    public String getConsultantTel() {
        return consultantTel;
    }

    public void setConsultantTel(String consultantTel) {
        this.consultantTel = consultantTel;
    }

    public List<Consultantorganisation> getConsultantorganisationList() {
        return consultantorganisationList;
    }

    public void setConsultantorganisationList(List<Consultantorganisation> consultantorganisationList) {
        this.consultantorganisationList = consultantorganisationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultantID != null ? consultantID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultant)) {
            return false;
        }
        Consultant other = (Consultant) object;
        if ((this.consultantID == null && other.consultantID != null) || (this.consultantID != null && !this.consultantID.equals(other.consultantID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.eqm.data.Consultant[ consultantID=" + consultantID + " ]";
    }
    
}
