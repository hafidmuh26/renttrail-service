package batchfour.teamtwo.renttrailservice.models;

public class ItemRequest {

    private String name;
    private Integer price;
    private Integer brandId;
    private Integer varietyId;
    private String picture;

    public ItemRequest() {
    }

    public ItemRequest(String name, Integer price, Integer brandId, Integer varietyId, String picture) {
        this.name = name;
        this.price = price;
        this.brandId = brandId;
        this.varietyId = varietyId;
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
