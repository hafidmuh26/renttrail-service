package batchfour.teamtwo.renttrailservice.entities;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction extends AbstractEntity {

    private Integer grandTotal;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private StatusTransaction status;

    @OneToOne
    private Rent rent;

    public Transaction() {
    }

    public Transaction(Integer grandTotal, StatusTransaction status, Rent rent) {
        this.grandTotal = grandTotal;
        this.status = status;
        this.rent = rent;
    }

    public Integer getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Integer grandTotal) {
        this.grandTotal = grandTotal;
    }

    public StatusTransaction getStatus() {
        return status;
    }

    public void setStatus(StatusTransaction status) {
        this.status = status;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }
}
