package PatternsJSON;

public class JCourier {

    private String login;
    private String password;
    private String firstName;
    private String id;

      public String getLogin() {
         return login;
     }

     public String getPassword() {
         return password;
     }

     public String getId() {
         return id;
     }

    public JCourier(){

    }

    public JCourier withLogin(String login){
        this.login = login;
        return this;
    }

    public JCourier withPassword(String password){
        this.password = password;
        return this;
    }

    public JCourier withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }
}
