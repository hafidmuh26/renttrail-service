package batchfour.teamtwo.renttrailservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="item")
@Entity
public class Item extends AbstractEntity {

    private String name;
    private String description;
    private Integer quantity;
    private String picture;

    public Item() {
    }

    public Item(String name, String description, Integer quantity, String picture) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
