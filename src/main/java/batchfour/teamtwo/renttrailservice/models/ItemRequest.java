package batchfour.teamtwo.renttrailservice.models;

public class ItemRequest {

    private String name;
<<<<<<< Updated upstream
    private Integer price;
    private Integer brandId;
    private Integer varietyId;
=======

    @MinLength(3)
    @MaxLength(50)
    @NotBlank(message = "Description can't blank!")
    private String description;

    @NotNull(message = "Quantity can't Null")
    private Integer quantity;
>>>>>>> Stashed changes

    public ItemRequest() {
    }

<<<<<<< Updated upstream
    public ItemRequest(String name, Integer price, Integer brandId, Integer varietyId) {
        this.name = name;
        this.price = price;
        this.brandId = brandId;
        this.varietyId = varietyId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
=======
    public ItemRequest(Integer id, String name, String description, Integer quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
>>>>>>> Stashed changes
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBrandId() {
        return this.brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getVarietyId() {
        return this.varietyId;
    }

    public void setVarietyId(Integer varietyId) {
        this.varietyId = varietyId;
    }

}
