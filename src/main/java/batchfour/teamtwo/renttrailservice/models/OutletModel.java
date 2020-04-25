package batchfour.teamtwo.renttrailservice.models;

public class OutletModel {

    private Integer id;
    private String name;
    private String telp;
    private String address;

    public OutletModel() {
    }

    public OutletModel(Integer id, String name, String telp, String address) {
        this.id = id;
        this.name = name;
        this.telp = telp;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
