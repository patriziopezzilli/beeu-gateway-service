package com.beeu.gatewayservice.message;

import java.io.Serializable;

public class UserMessage implements Serializable {

    private String id;
    private String title;
    private String name;
    private String middleName;
    private String surname;
    private String company;
    private String url;
    private String fiscalCode;
    private String birthdate;
    private String relation;
    private String note;
    private Boolean active;
    private Boolean marketing_accepted;
    private Boolean service_accepted;

    public UserMessage() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getMarketing_accepted() {
        return marketing_accepted;
    }

    public void setMarketing_accepted(Boolean marketing_accepted) {
        this.marketing_accepted = marketing_accepted;
    }

    public Boolean getService_accepted() {
        return service_accepted;
    }

    public void setService_accepted(Boolean service_accepted) {
        this.service_accepted = service_accepted;
    }
}
