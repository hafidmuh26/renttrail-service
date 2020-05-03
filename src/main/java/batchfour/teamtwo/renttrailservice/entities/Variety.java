package batchfour.teamtwo.renttrailservice.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "variety")
public class Variety extends AbstractEntity {

    private String name;

    public Variety() {
    }

    public Variety(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}