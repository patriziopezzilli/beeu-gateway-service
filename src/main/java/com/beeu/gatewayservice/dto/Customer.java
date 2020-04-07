package com.beeu.gatewayservice.dto;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {

    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String parent; //bee id
    private String vatCode;
    private String category;
    private String apiKey;
    private String note;

    public Customer() {
    }

    public Customer(String name, String email, String phoneNumber, String parent, String vatCode, String category, String apiKey, String note) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.parent = parent;
        this.vatCode = vatCode;
        this.category = category;
        this.apiKey = apiKey;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getVatCode() {
        return vatCode;
    }

    public void setVatCode(String vatCode) {
        this.vatCode = vatCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(phoneNumber, customer.phoneNumber) &&
                Objects.equals(parent, customer.parent) &&
                Objects.equals(vatCode, customer.vatCode) &&
                Objects.equals(category, customer.category) &&
                Objects.equals(apiKey, customer.apiKey) &&
                Objects.equals(note, customer.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phoneNumber, parent, vatCode, category, apiKey, note);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phonenumber='").append(phoneNumber).append('\'');
        sb.append(", parent='").append(parent).append('\'');
        sb.append(", vatCode='").append(vatCode).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", apiKey='").append(apiKey).append('\'');
        sb.append(", note='").append(note).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
