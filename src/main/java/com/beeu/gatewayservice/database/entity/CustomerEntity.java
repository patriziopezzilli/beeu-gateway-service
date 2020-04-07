package com.beeu.gatewayservice.database.entity;

import com.beeu.gatewayservice.database.converter.CryptoConverter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Table(name = "BEEU_CUSTOMER")
@Entity
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Convert(converter = CryptoConverter.class)
    private String email;

    @Convert(converter = CryptoConverter.class)
    private String phonenumber;
    private String parent_customer; //bee id

    @Convert(converter = CryptoConverter.class)
    private String vatCode;
    private String category;

    @Convert(converter = CryptoConverter.class)
    private String apiKey;
    private String note;
    private Boolean active;
    private Date creation_date;
    private Date last_update_date;

    @ManyToOne
    private PlanEntity plan;

    @Column(name = "BEE_ID")
    private String beeId;

    public CustomerEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getParent_customer() {
        return parent_customer;
    }

    public void setParent_customer(String parent_customer) {
        this.parent_customer = parent_customer;
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

    public PlanEntity getPlan() {
        return plan;
    }

    public void setPlan(PlanEntity plan) {
        this.plan = plan;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Date last_update_date) {
        this.last_update_date = last_update_date;
    }

    public String getBeeId() {
        return beeId;
    }

    public void setBeeId(String beeId) {
        this.beeId = beeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phonenumber, that.phonenumber) &&
                Objects.equals(parent_customer, that.parent_customer) &&
                Objects.equals(vatCode, that.vatCode) &&
                Objects.equals(category, that.category) &&
                Objects.equals(plan, that.plan) &&
                Objects.equals(apiKey, that.apiKey) &&
                Objects.equals(note, that.note) &&
                Objects.equals(active, that.active) &&
                Objects.equals(creation_date, that.creation_date) &&
                Objects.equals(last_update_date, that.last_update_date) &&
                Objects.equals(beeId, that.beeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phonenumber, parent_customer, vatCode, category, plan, apiKey, note, active, creation_date, last_update_date, beeId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomerEntity{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phonenumber='").append(phonenumber).append('\'');
        sb.append(", parent_customer='").append(parent_customer).append('\'');
        sb.append(", vatCode='").append(vatCode).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", plan='").append(plan).append('\'');
        sb.append(", apiKey='").append(apiKey).append('\'');
        sb.append(", note='").append(note).append('\'');
        sb.append(", active=").append(active);
        sb.append(", creation_date=").append(creation_date);
        sb.append(", last_update_date=").append(last_update_date);
        sb.append(", beeId='").append(beeId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
