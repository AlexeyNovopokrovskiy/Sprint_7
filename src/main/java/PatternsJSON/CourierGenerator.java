package PatternsJSON;

public class CourierGenerator {

    public static JCourier randomCourier(){
    return new JCourier()
            .withLogin(Utils.randomString(6))
            .withPassword(Utils.randomString(8))
            .withFirstName(Utils.randomString(10));
    }



    public static JCourier randomCourierNoFirstName(){
        return new JCourier()
                .withLogin(Utils.randomString(6))
                .withPassword(Utils.randomString(8));
    }

    public static JCourier randomCourierNoLogin(){
        return new JCourier()
                .withPassword(Utils.randomString(8))
                .withFirstName(Utils.randomString(10));
    }

    public static JCourier randomCourierNoPassword(){
        return new JCourier()
                .withLogin(Utils.randomString(6))
                .withFirstName(Utils.randomString(10));
    }


}
