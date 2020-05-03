package batchfour.teamtwo.renttrailservice.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rent")
public class Rent extends AbstractEntity {

    private Integer totalPrice;
    private LocalDate dateStart;
    private LocalDate dateEnd;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Item item;

    @OneToOne
    private User user;

    public Rent() {
    }

    public Rent(Integer totalPrice, LocalDate dateStart, LocalDate dateEnd, Item item, User user) {
        this.totalPrice = totalPrice;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.item = item;
        this.user = user;
    }

    public Integer getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getDateStart() {
        return this.dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return this.dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
