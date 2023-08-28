package PatternsJSON;

public class JOrders {

    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private String[] color; //необяз

    public JOrders(){

    }

    public JOrders(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, String[] color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

    public JOrders(String[] color) {

    }

    public JOrders withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }
    public JOrders withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public JOrders withAddress(String address) {
        this.address = address;
        return this;
    }
    public JOrders withMetroStation(String metroStation) {
        this.metroStation = metroStation;
        return this;
    }
    public JOrders withPhone(String phone) {
        this.phone = phone;
        return this;
    }
    public JOrders withRentTime(int rentTime) {
        this.rentTime = rentTime;
        return this;
    }
    public JOrders withDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }
    public JOrders withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public JOrders withColor(String[] color) {
        this.color = color;
        return this;
    }


}
