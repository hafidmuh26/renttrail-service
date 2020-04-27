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

    public Item() {
    }

    public Item(String name, Integer price, Brand brand, Variety variety) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.variety = variety;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Variety getVariety() {
        return this.variety;
    }

    public void setVariety(Variety variety) {
        this.variety = variety;
    }

}
