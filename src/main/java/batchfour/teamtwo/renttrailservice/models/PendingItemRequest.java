package batchfour.teamtwo.renttrailservice.models;

import batchfour.teamtwo.renttrailservice.entities.Partner;

public class PendingItemRequest {

    private Integer id;
    private String name;
    private Integer quantity;
    private String age;
    private String status;
    private String description;
    private Integer partner;

    public PendingItemRequest() {
    }

    public PendingItemRequest(Integer id, String name, Integer quantity, String age, String status, String description, Integer partner) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.age = age;
        this.status = status;
        this.description = description;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPartner() {
        return partner;
    }

    public void setPartner(Integer partner) {
        this.partner = partner;
    }
}
