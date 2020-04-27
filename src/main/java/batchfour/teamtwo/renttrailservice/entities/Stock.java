package batchfour.teamtwo.renttrailservice.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock extends AbstractEntity {

    private Item item;
    private Integer quantity;

    public Stock() {
    }

}