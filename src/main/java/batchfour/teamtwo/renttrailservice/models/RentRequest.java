package batchfour.teamtwo.renttrailservice.models;

import java.time.LocalDate;

public class RentRequest {

    private Integer id;
    private Integer totalPrice;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private ItemRequest item;
    private UserRequest user;
    private String status;

    public RentRequest() {
    }

    public RentRequest(Integer id, Integer totalPrice, LocalDate dateStart,
                       LocalDate dateEnd, ItemRequest item, UserRequest user, String status) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.item = item;
        this.user = user;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
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
}
