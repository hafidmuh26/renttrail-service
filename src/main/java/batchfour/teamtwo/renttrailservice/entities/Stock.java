package batchfour.teamtwo.renttrailservice.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock extends AbstractEntity {

    private Integer quantity;

    @OneToOne
    private PendingItem item;

    public Stock() {
    }

    public Stock(PendingItem item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public PendingItem getPendingItem() {
        return this.item;
    }

    public void setPendingItem(PendingItem item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
