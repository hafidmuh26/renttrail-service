package batchfour.teamtwo.renttrailservice.entities;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction extends AbstractEntity {

    private Integer grandTotal;

    @OneToOne
    private Rent rent;

    public Transaction() {
    }

    public Transaction(Integer grandTotal, Rent rent) {
        this.grandTotal = grandTotal;
        this.rent = rent;
    }

    public Integer getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Integer grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }
}
