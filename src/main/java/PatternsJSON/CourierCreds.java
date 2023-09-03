package PatternsJSON;

public class CourierCreds {
    private String login;
    private String password;
    private String firstName;

    public CourierCreds(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public CourierCreds(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static CourierCreds credsFrom(JCourier courier){
        return new CourierCreds(courier.getLogin(), courier.getPassword());
    }

    public static CourierCreds credsFromCreate(JCourier courier){
        return new CourierCreds(courier.getLogin(), Utils.randomString(8), Utils.randomString(10));
    }
    public static CourierCreds credsChangedLogin(JCourier courier){
        String newLogin = courier.getLogin() + "1";
        return new CourierCreds(newLogin, courier.getPassword());
    }

    public static CourierCreds credsChangedPassword(JCourier courier){
        String newPassword = courier.getPassword() + "1";
        return new CourierCreds(courier.getLogin(), newPassword);
    }

    public static CourierCreds credsNullifiedLogin(JCourier courier){
        String newLogin = "";
        return new CourierCreds(newLogin, courier.getPassword());
    }

    public static CourierCreds credsNullifiedPassword(JCourier courier){
        String newPassword = "";
        return new CourierCreds(courier.getLogin(), newPassword);
    }

    public static CourierCreds randomCourierGet(){
        return new CourierCreds(Utils.randomString(8), Utils.randomString(9));
    }


}
