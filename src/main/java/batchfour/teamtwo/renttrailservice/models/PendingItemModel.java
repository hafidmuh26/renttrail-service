package batchfour.teamtwo.renttrailservice.models;

public class PendingItemModel {

    private Integer id;
    private String name;
    private String brand;
    private String age;
    private Integer price;
    private String status;
    private String picture;
    private PartnerRequest partner;
    private VarietyRequest variety;

    public PendingItemModel() {
    }

    public PendingItemModel(Integer id, String name, String brand, String age, Integer price, String status,
                            String picture, PartnerRequest partner, VarietyRequest variety) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.age = age;
        this.price = price;
        this.status = status;
        this.picture = picture;
        this.partner = partner;
        this.variety = variety;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public PartnerRequest getPartner() {
        return partner;
    }

    public void setPartner(PartnerRequest partner) {
        this.partner = partner;
    }

    public VarietyRequest getVariety() {
        return variety;
    }

    public void setVariety(VarietyRequest variety) {
        this.variety = variety;
    }
}
