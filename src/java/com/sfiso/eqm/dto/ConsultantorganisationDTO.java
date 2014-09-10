/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sfiso.eqm.dto;

import com.sifiso.eqm.data.Consultant;
import com.sifiso.eqm.data.Consultantorganisation;
import com.sifiso.eqm.data.Organisation;


/**
 *
 * @author CodeTribe1
 */
public class ConsultantorganisationDTO {

    private Integer consultantOrganisationID;
    
    private int consultantID;
    private String consultantName, consultantSurname, organisitionName;
    private int organisationID;

    public ConsultantorganisationDTO(Consultantorganisation d) {
        consultantOrganisationID = d.getConsultantOrganisationID();
        Consultant c = d.getConsultant();
        consultantID = c.getConsultantID();
        consultantName = c.getConsultantName();
        consultantSurname = c.getConsultantSurname();
        Organisation o = d.getOrganisation();
        organisationID = o.getOrganisationID();
        organisitionName = o.getOrganisationName();
    }

    public Integer getConsultantOrganisationID() {
        return consultantOrganisationID;
    }

    public void setConsultantOrganisationID(Integer consultantOrganisationID) {
        this.consultantOrganisationID = consultantOrganisationID;
    }

    public int getConsultantID() {
        return consultantID;
    }

    public void setConsultantID(int consultantID) {
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

    public String getOrganisitionName() {
        return organisitionName;
    }

    public void setOrganisitionName(String organisitionName) {
        this.organisitionName = organisitionName;
    }

    public int getOrganisationID() {
        return organisationID;
    }

    public void setOrganisationID(int organisationID) {
        this.organisationID = organisationID;
    }
    

}
