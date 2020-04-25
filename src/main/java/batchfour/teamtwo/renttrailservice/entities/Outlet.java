package batchfour.teamtwo.renttrailservice.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "outlet")
@Entity
public class Outlet extends AbstractEntity{

    private String name;
    private String telp;
    private String address;

    public Outlet() {
    }

    public Outlet(String name, String telp, String address) {
        this.name = name;
        this.telp = telp;
        this.address = address;
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
