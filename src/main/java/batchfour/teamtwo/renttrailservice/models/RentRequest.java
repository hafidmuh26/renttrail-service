package batchfour.teamtwo.renttrailservice.models;

import java.time.LocalDate;

public class RentRequest {

    private Integer totalPrice;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private Integer itemId;
    private Integer userId;

    public RentRequest() {
    }

    public RentRequest(Integer totalPrice, LocalDate dateStart, LocalDate dateEnd, Integer itemId, Integer userId) {
        this.totalPrice = totalPrice;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.itemId = itemId;
        this.userId = userId;
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

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
