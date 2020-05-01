package batchfour.teamtwo.renttrailservice.models;

public class TransactionRequest {

    private Integer grandTotal;
    private String status;
    private Integer rentId;

    public TransactionRequest() {
    }

    public TransactionRequest(Integer grandTotal, String status, Integer rentId) {
        this.grandTotal = grandTotal;
        this.status = status;
        this.rentId = rentId;
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

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }
}
