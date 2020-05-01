package batchfour.teamtwo.renttrailservice.models;

public class StockRequest {

    private Integer quantity;
    private Integer itemId;

    public StockRequest() {
    }

    public StockRequest(Integer itemId, Integer quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public Integer getItemId() {
        return this.itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
