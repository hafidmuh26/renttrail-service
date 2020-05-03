package batchfour.teamtwo.renttrailservice.models;

public class StockModel {

    private Integer id;
    private ItemModel item;
    private Integer quantity;

    public StockModel() {
    }

    public StockModel(Integer id, ItemModel item, Integer quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemModel getItem() {
        return this.item;
    }

    public void setItem(ItemModel item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}