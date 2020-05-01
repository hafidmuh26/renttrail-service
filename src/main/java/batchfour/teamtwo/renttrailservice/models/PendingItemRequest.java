package batchfour.teamtwo.renttrailservice.models;


public class PendingItemRequest {

    private String name;
    private String brand;
    private String age;
    private Integer price;
    private String status;
    private String picture;
    private Integer partnerId;
    private Integer varietyId;

    public PendingItemRequest() {
    }

    public PendingItemRequest(String name, String brand, String age, Integer price, String status, String picture, Integer partnerId, Integer varietyId) {
        this.name = name;
        this.brand = brand;
        this.age = age;
        this.price = price;
        this.status = status;
        this.picture = picture;
        this.partnerId = partnerId;
        this.varietyId = varietyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getVarietyId() {
        return varietyId;
    }

    public void setVarietyId(Integer varietyId) {
        this.varietyId = varietyId;
    }
}
