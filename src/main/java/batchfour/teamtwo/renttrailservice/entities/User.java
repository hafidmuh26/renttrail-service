package batchfour.teamtwo.renttrailservice.entities;
import javax.persistence.*;

@Table(name = "user")
@Entity
public class User extends AbstractEntity {

    private String name;

    private String nik;

    private String noHp;

    private String address;

    private String gender;

    private String picture;

    @OneToOne
    private Account account;

    public User() {
    }

    public User(String name, String nik, String noHp, String address, String gender, String picture, Account account) {
        this.name = name;
        this.nik = nik;
        this.noHp = noHp;
        this.address = address;
        this.gender = gender;
        this.picture = picture;
        this.account = account;
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
}
