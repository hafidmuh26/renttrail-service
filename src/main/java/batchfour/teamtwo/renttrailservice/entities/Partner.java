package batchfour.teamtwo.renttrailservice.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "outlet")
@Entity
public class Partner extends AbstractEntity{

    private String name;
    private String telp;
    private String address;
    private String picture;

    public Partner() {
    }

    public Partner(String name, String telp, String address, String picture) {
        this.name = name;
        this.telp = telp;
        this.address = address;
        this.picture = picture;
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
