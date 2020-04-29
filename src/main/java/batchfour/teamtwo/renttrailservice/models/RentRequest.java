package batchfour.teamtwo.renttrailservice.models;

import java.time.LocalDate;

public class RentRequest {

    private Integer totalRent;
    private Integer totalPrice;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private Integer itemId;
    private Integer userId;

    public RentRequest() {
    }

    public RentRequest(Integer totalRent, Integer totalPrice, LocalDate dateStart, LocalDate dateEnd, Integer itemId,
            Integer userId) {
        this.totalRent = totalRent;
        this.totalPrice = totalPrice;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.itemId = itemId;
        this.userId = userId;
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

    public Integer getItemId() {
        return this.itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
