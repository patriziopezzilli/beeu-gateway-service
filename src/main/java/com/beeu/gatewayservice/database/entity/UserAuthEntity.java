package com.beeu.gatewayservice.database.entity;

import com.beeu.gatewayservice.database.converter.CryptoConverter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Table(name = "BEEU_USER_AUTH")
@Entity
public class UserAuthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Convert(converter = CryptoConverter.class)
    private String password;

    @Convert(converter = CryptoConverter.class)
    private String pincode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    private Date creation_date;
    private Date last_update_date;

    public UserAuthEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
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

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}
