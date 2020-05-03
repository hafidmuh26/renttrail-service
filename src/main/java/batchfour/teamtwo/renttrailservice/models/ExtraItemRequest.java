package batchfour.teamtwo.renttrailservice.models;

public class ExtraItemRequest {

    private Integer id;
    private String name;

    public ExtraItemRequest() {
    }

    public ExtraItemRequest(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}