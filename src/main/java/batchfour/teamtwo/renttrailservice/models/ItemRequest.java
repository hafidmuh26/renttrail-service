package batchfour.teamtwo.renttrailservice.models;

public class ItemRequest {

    private String name;
    private Integer price;
    private Integer brandId;
    private Integer varietyId;

    public ItemRequest() {
    }

    public ItemRequest(String name, Integer price, Integer brandId, Integer varietyId) {
        this.name = name;
        this.price = price;
        this.brandId = brandId;
        this.varietyId = varietyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getVarietyId() {
        return varietyId;
    }

    public void setVarietyId(Integer varietyId) {
        this.varietyId = varietyId;
    }
}
