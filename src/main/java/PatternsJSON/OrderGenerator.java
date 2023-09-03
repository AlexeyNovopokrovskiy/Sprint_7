package PatternsJSON;

public class OrderGenerator {

    public static JOrders orders(String[] colour) {
        return new JOrders(colour)
                .withFirstName(Utils.randomString(8))
                .withLastName(Utils.randomString(9))
                .withAddress(Utils.randomString(10))
                .withMetroStation(Utils.randomString(11))
                .withPhone(Utils.randomString(7))
                .withRentTime(Utils.rnd(8))
                .withDeliveryDate(Utils.rndDate())
                .withComment(Utils.randomString(20))
                .withColor(colour)
                ;
    }

    public static JOrders orderNew() {
        return new JOrders()
                .withFirstName(Utils.randomString(8))
                .withLastName(Utils.randomString(9))
                .withAddress(Utils.randomString(10))
                .withMetroStation(Utils.randomString(11))
                .withPhone(Utils.randomString(7))
                .withRentTime(Utils.rnd(8))
                .withDeliveryDate(Utils.rndDate())
                .withComment(Utils.randomString(20))
                ;

    }
}
