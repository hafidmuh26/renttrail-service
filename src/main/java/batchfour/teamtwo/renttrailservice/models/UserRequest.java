package batchfour.teamtwo.renttrailservice.models;

import batchfour.teamtwo.renttrailservice.validation.annotations.MaxLength;
import batchfour.teamtwo.renttrailservice.validation.annotations.MinLength;
import javax.validation.constraints.NotBlank;

public class UserRequest {

    private Integer id;

    @MinLength(3)
    @MaxLength(20)
    @NotBlank(message = "Name can't blankk!")
    private String name;

    @MaxLength(16)
    @MinLength(16)
    @NotBlank(message = "Nik can't blankk!")
    private String nik;

    @NotBlank(message = "Number Handphone can't blank!")
    private String noHp;

    @NotBlank(message = "Address can't blankk!")
    private String address;

    @NotBlank(message = "Gender can't blank")
    private String gender;
    private String picture;

    public UserRequest() {
    }

    public UserRequest(Integer id, String name, String nik, String noHp, String address, String gender,
            String picture) {
        this.id = id;
        this.name = name;
        this.nik = nik;
        this.noHp = noHp;
        this.address = address;
        this.gender = gender;
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", nik='" + getNik() + "'" + ", noHp='"
                + getNoHp() + "'" + ", address='" + getAddress() + "'" + ", gender='" + getGender() + "'"
                + ", picture='" + getPicture() + "'" + "}";
    }

}
