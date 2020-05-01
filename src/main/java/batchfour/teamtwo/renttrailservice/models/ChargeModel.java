package batchfour.teamtwo.renttrailservice.models;

public class ChargeModel {

    private Integer id;
    private String description;
    private Integer price;
    private ItemRequest item;
    private UserRequest user;
    private RentRequest rent;

    public ChargeModel() {
    }

    public ChargeModel(Integer id, String description, Integer price,
                       ItemRequest item, UserRequest user, RentRequest rent) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.item = item;
        this.user = user;
        this.rent = rent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ItemRequest getItem() {
        return item;
    }

    public void setItem(ItemRequest item) {
        this.item = item;
    }

    public UserRequest getUser() {
        return user;
    }

    public void setUser(UserRequest user) {
        this.user = user;
    }

    public RentRequest getRent() {
        return rent;
    }

    public void setRent(RentRequest rent) {
        this.rent = rent;
    }
}
