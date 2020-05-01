package batchfour.teamtwo.renttrailservice.models;

public class StockRequest {

    private Integer id;
    private PendingItemRequest item;
    private Integer quantity;

    public StockRequest() {
    }

    public StockRequest(Integer id, PendingItemRequest item, Integer quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PendingItemRequest getItem() {
        return item;
    }

    public void setItem(PendingItemRequest item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
