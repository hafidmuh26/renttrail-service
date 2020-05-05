package batchfour.teamtwo.renttrailservice.models;

import batchfour.teamtwo.renttrailservice.validation.annotations.MaxLength;
import batchfour.teamtwo.renttrailservice.validation.annotations.MinLength;

import javax.validation.constraints.NotBlank;

public class PartnerRequest {

    private Integer id;

    @MinLength(3)
    @MaxLength(20)
    @NotBlank(message = "Name can't banlk!")
    private String name;

    @NotBlank(message = "Telephone can't banlk!")
    private String telp;

    @NotBlank(message = "Address can't banlk!")
    private String address;

    private String picture;

    private AccountRequest account;

    public PartnerRequest() {
    }

    public PartnerRequest(Integer id, String name, String telp, String address, String picture, AccountRequest account) {
        this.id = id;
        this.name = name;
        this.telp = telp;
        this.address = address;
        this.picture = picture;
        this.account = account;
    }

    public AccountRequest getAccount() {
        return account;
    }

    public void setAccount(AccountRequest account) {
        this.account = account;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
