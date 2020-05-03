package batchfour.teamtwo.renttrailservice.models;

public class TransactionModel {

    private Integer id;
    private Integer grandTotal;
    private String status;
    private RentModel rent;
    private ChargeModel charge;

    public TransactionModel() {
    }

    public TransactionModel(Integer id, Integer grandTotal, String status, RentModel rent, ChargeModel charge) {
        this.id = id;
        this.grandTotal = grandTotal;
        this.status = status;
        this.rent = rent;
        this.charge = charge;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public RentModel getRent() {
        return this.rent;
    }

    public void setRent(RentModel rent) {
        this.rent = rent;
    }

    public ChargeModel getCharge() {
        return this.charge;
    }

    public void setCharge(ChargeModel charge) {
        this.charge = charge;
    }

}