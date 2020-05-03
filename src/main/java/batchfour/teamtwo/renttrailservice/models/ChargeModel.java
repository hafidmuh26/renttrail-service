package batchfour.teamtwo.renttrailservice.models;

public class ChargeModel {

    private Integer id;
    private String description;
    private Integer price;
    private ItemModel item;
    private UserRequest user;

    public ChargeModel() {
    }

    public ChargeModel(Integer id, String description, Integer price, ItemModel item, UserRequest user) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.item = item;
        this.user = user;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ItemModel getItem() {
        return this.item;
    }

    public void setItem(ItemModel item) {
        this.item = item;
    }

    public UserRequest getUser() {
        return this.user;
    }

    public void setUser(UserRequest user) {
        this.user = user;
    }

}