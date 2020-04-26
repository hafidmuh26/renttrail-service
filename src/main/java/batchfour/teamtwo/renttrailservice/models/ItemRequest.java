package batchfour.teamtwo.renttrailservice.models;

import batchfour.teamtwo.renttrailservice.validation.annotations.MaxLength;
import batchfour.teamtwo.renttrailservice.validation.annotations.MinLength;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemRequest {

    private Integer id;

    @MinLength(3)
    @MaxLength(20)
    @NotBlank(message = "Name can't banlk!")
    private String name;

    @MinLength(3)
    @MaxLength(50)
    @NotBlank(message = "Description can't blank!")
    private String description;

    @NotNull(message = "Quantity can't Null")
    private Integer quantity;
    private String picture;

    public ItemRequest() {
    }

    public ItemRequest(Integer id, String name, String description, Integer quantity, String picture) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
