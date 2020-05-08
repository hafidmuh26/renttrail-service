package batchfour.teamtwo.renttrailservice.models;

public class ItemRequest {

    private Integer id;
    private String name;
    private Integer price;
    private String brand;
    private String variety;
    private String picture;
    private PartnerRequest partner;

    public ItemRequest() {
    }

<<<<<<< Updated upstream
    public ItemRequest(Integer id, String name, Integer price, String brand, String variety, String picture, PartnerRequest partner) {
=======
    public ItemRequest(Integer id, String name, Integer price, String brand, String variety,
                       String picture, PartnerRequest partner) {
>>>>>>> Stashed changes
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.variety = variety;
        this.picture = picture;
        this.partner = partner;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
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
}
