package batchfour.teamtwo.renttrailservice.entities;


import javax.persistence.*;

@Table(name = "pending_item")
@Entity
public class PendingItem extends AbstractEntity {

    private String name;
    private String brand;
    private String age;
    private Integer price;
    private StatusItem status;
    private String picture;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Partner partner;

    @JoinColumn(nullable = false)
    @OneToOne
    private Variety variety;

    public PendingItem() {
    }

    public PendingItem(String name, String brand, String age, Integer price, StatusItem status, String picture, Partner partner, Variety variety) {
        this.name = name;
        this.brand = brand;
        this.age = age;
        this.price = price;
        this.status = status;
        this.picture = picture;
        this.partner = partner;
        this.variety = variety;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public StatusItem getStatus() {
        return status;
    }

    public void setStatus(StatusItem status) {
        this.status = status;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Variety getVariety() {
        return variety;
    }

    public void setVariety(Variety variety) {
        this.variety = variety;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
