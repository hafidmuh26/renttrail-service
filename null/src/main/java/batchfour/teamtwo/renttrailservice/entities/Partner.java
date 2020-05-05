package batchfour.teamtwo.renttrailservice.entities;

import javax.persistence.*;

@Table(name = "partner")
@Entity
public class Partner extends AbstractEntity{

    private String name;
    private String owner;
    private String telp;
    private String address;
    private String picture;

    @OneToOne
    private Account account;

    public Partner() {
    }

    public Partner(String name, String owner, String telp, String address, String picture, Account account) {
        this.name = name;
        this.owner = owner;
        this.telp = telp;
        this.address = address;
        this.picture = picture;
        this.account = account;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
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

}
