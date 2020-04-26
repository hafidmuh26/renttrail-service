package batchfour.teamtwo.renttrailservice.models;

import batchfour.teamtwo.renttrailservice.validation.annotations.MaxLength;
import batchfour.teamtwo.renttrailservice.validation.annotations.MinLength;

import javax.validation.constraints.NotBlank;

public class OutletRequest {

    private Integer id;

    @MinLength(3)
    @MaxLength(20)
    @NotBlank(message = "Name can't banlk!")
    private String name;

    @NotBlank(message = "Telephone can't banlk!")
    private String telp;

    @NotBlank(message = "Address can't banlk!")
    private String address;

    public OutletRequest() {
    }

    public OutletRequest(Integer id, String name, String telp, String address) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
