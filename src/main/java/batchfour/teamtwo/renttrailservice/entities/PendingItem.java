package batchfour.teamtwo.renttrailservice.entities;


import javax.persistence.*;

@Table(name="pending_item")
@Entity
public class PendingItem extends AbstractEntity {

    private String name;
    private Integer quantity;
    private String age;
    private String status;
    private String description;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Partner partner;

    public PendingItem() {
    }

    public PendingItem(String name, Integer quantity, String age, String status, String description, Partner partner) {
        this.name = name;
        this.quantity = quantity;
        this.age = age;
        this.status = status;
        this.description = description;
        this.partner = partner;
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

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}
