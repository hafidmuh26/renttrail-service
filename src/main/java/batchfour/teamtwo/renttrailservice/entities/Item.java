package batchfour.teamtwo.renttrailservice.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item extends AbstractEntity {

    private String name;
    private Integer price;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Variety variety;

    private String picture;

    public Item() {
    }

    public Item(String name, Integer price, Brand brand, Variety variety, String picture) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.variety = variety;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Variety getVariety() {
        return variety;
    }

    public void setVariety(Variety variety) {
        this.variety = variety;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", price='" + getPrice() + "'" + ", brand='" + getBrand() + "'"
                + ", variety='" + getVariety() + "'" + ", picture='" + getPicture() + "'" + "}";
    }

}
