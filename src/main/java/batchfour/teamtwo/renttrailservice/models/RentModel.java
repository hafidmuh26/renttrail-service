package batchfour.teamtwo.renttrailservice.models;

import java.time.LocalDate;

public class RentModel {

    private Integer id;
    private Integer totalRent;
    private Integer totalPrice;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private ItemModel item;
    private UserRequest user;

    public RentModel() {
    }

    public RentModel(Integer id, Integer totalRent, Integer totalPrice, LocalDate dateStart, LocalDate dateEnd,
            ItemModel item, UserRequest user) {
        this.id = id;
        this.totalRent = totalRent;
        this.totalPrice = totalPrice;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.item = item;
        this.user = user;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalRent() {
        return this.totalRent;
    }

    public void setTotalRent(Integer totalRent) {
        this.totalRent = totalRent;
    }

    public Integer getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getDateStart() {
        return this.dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return this.dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
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

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", totalRent='" + getTotalRent() + "'" + ", totalPrice='"
                + getTotalPrice() + "'" + ", dateStart='" + getDateStart() + "'" + ", dateEnd='" + getDateEnd() + "'"
                + ", item='" + getItem() + "'" + ", user='" + getUser() + "'" + "}";
    }

}
