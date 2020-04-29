package batchfour.teamtwo.renttrailservice.models;

public class ChargeRequest {

    private String description;
    private Integer price;
    private Integer ItemId;
    private Integer UserId;

    public ChargeRequest() {
    }

    public ChargeRequest(String description, Integer price, Integer ItemId, Integer UserId) {
        this.description = description;
        this.price = price;
        this.ItemId = ItemId;
        this.UserId = UserId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getItemId() {
        return this.ItemId;
    }

    public void setItemId(Integer ItemId) {
        this.ItemId = ItemId;
    }

    public Integer getUserId() {
        return this.UserId;
    }

    public void setUserId(Integer UserId) {
        this.UserId = UserId;
    }

}