package batchfour.teamtwo.renttrailservice.models;

public class ItemModel {

    private Integer id;
    private String name;
    private Integer price;
    private ExtraItemRequest brand;
    private ExtraItemRequest variety;

    public ItemModel() {
    }

    public ItemModel(Integer id, String name, Integer price, ExtraItemRequest brand, ExtraItemRequest variety) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.variety = variety;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ExtraItemRequest getBrand() {
        return this.brand;
    }

    public void setBrand(ExtraItemRequest brand) {
        this.brand = brand;
    }

    public ExtraItemRequest getVariety() {
        return this.variety;
    }

    public void setVariety(ExtraItemRequest variety) {
        this.variety = variety;
    }

}