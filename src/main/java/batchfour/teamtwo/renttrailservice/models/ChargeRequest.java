package batchfour.teamtwo.renttrailservice.models;

public class ChargeRequest {

    private String description;
    private Integer price;
    private Integer itemId;
    private Integer userId;
    private Integer rentId;

    public ChargeRequest() {
    }

    public ChargeRequest(String description, Integer price,
                         Integer itemId, Integer userId, Integer rentId) {
        this.description = description;
        this.price = price;
        this.itemId = itemId;
        this.userId = userId;
        this.rentId = rentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }
}
