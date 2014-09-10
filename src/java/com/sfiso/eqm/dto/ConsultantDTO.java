/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sfiso.eqm.dto;


import com.sifiso.eqm.data.Consultant;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class ConsultantDTO {

    private Integer consultantID;
    private String consultantName;
    private String consultantSurname;
    private String consultantEmail;
    private String consultantTel;
    private List<ConsultantorganisationDTO> consultantorganisationList;

    public ConsultantDTO(Consultant c) {
        consultantID = c.getConsultantID();
        consultantName = c.getConsultantName();
        consultantSurname = c.getConsultantSurname();
        consultantEmail = c.getConsultantEmail();
        consultantTel = c.getConsultantTel();
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

    public List<ConsultantorganisationDTO> getConsultantorganisationList() {
        return consultantorganisationList;
    }

    public void setConsultantorganisationList(List<ConsultantorganisationDTO> consultantorganisationList) {
        this.consultantorganisationList = consultantorganisationList;
    }

}
