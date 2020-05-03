package batchfour.teamtwo.renttrailservice.models;

public class TransactionRequest {

    private Integer id;
    private Integer grandTotal;
    private String status;
    private RentRequest rent;

    public TransactionRequest() {
    }

    public TransactionRequest(Integer id, Integer grandTotal, String status, RentRequest rent) {
        this.id = id;
        this.grandTotal = grandTotal;
        this.status = status;
        this.rent = rent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Integer grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RentRequest getRent() {
        return rent;
    }

    public void setRent(RentRequest rent) {
        this.rent = rent;
    }
}
