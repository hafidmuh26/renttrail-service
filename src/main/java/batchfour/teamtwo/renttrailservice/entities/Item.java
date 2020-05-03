package batchfour.teamtwo.renttrailservice.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item extends AbstractEntity {

    private String name;
    private Integer price;
    private String brand;
    private String variety;
    private String picture;

    public Item() {
    }

    public Item(String name, Integer price, String brand, String variety, String picture) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.variety = variety;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
