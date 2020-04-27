// package batchfour.teamtwo.renttrailservice.entities;

// import javax.persistence.Entity;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;

// @Entity
// @Table(name = "rent")
// public class Rent extends AbstractEntity {

//     @ManyToOne
//     @JoinColumn(nullable = false)
//     private Item item;

//     private Integer price;
//     private Integer totalPrice;
//     private String status;

//     public Rent() {
//     }

//     public Rent(Item item, Integer price, Integer totalPrice, String status) {
//         this.item = item;
//         this.price = price;
//         this.totalPrice = totalPrice;
//         this.status = status;
//     }

//     public Item getItem() {
//         return item;
//     }

//     public void setItem(Item item) {
//         this.item = item;
//     }

//     public Integer getPrice() {
//         return price;
//     }

//     public void setPrice(Integer price) {
//         this.price = price;
//     }

//     public Integer getTotalPrice() {
//         return totalPrice;
//     }

//     public void setTotalPrice(Integer totalPrice) {
//         this.totalPrice = totalPrice;
//     }

//     public String getStatus() {
//         return status;
//     }

//     public void setStatus(String status) {
//         this.status = status;
//     }
// }
