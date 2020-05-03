package batchfour.teamtwo.renttrailservice.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "charge")
public class Charge extends AbstractEntity {

    private String description;
    private Integer price;

    @OneToOne
    @JoinColumn(nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Rent rent;


    public Charge() {
    }

    public Charge(String description, Integer price, User user, Item item, Rent rent) {
        this.description = description;
        this.price = price;
        this.user = user;
        this.item = item;
        this.rent = rent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }
}
