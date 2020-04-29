package batchfour.teamtwo.renttrailservice.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction extends AbstractEntity {

    private Integer grandTotal;
    private String status;

    @OneToOne
    private Rent rent;

    @OneToOne
    private Charge charge;

    public Transaction() {
    }

    public Transaction(Integer grandTotal, String status, Rent rent, Charge charge) {
        this.grandTotal = grandTotal;
        this.status = status;
        this.rent = rent;
        this.charge = charge;
    }

    public Integer getGrandTotal() {
        return this.grandTotal;
    }

    public void setGrandTotal(Integer grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Rent getRent() {
        return this.rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Charge getCharge() {
        return this.charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }

}