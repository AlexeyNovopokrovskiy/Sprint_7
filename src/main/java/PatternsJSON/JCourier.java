package PatternsJSON;

public class JCourier {

    private String login;
    private String password;
    private String firstName;

      public String getLogin() {
         return login;
     }

     public void setLogin(String login) {
         this.login = login;
      }

     public String getPassword() {
         return password;
     }

     public void setPassword(String password) {
         this.password = password;
     }

     public String getFirstName() {
         return firstName;
     }

     public void setFirstName(String firstName) {
         this.firstName = firstName;
     }

     public String getId() {
         return id;
     }

     public void setId(String id) {
         this.id = id;
     }

     public String getOrdersCount() {
         return ordersCount;
     }

     public void setOrdersCount(String ordersCount) {
         this.ordersCount = ordersCount;
     }

     private String id;
     private String ordersCount;

     public JCourier(String login, String password, String firstName){
         this.login = login;
         this.password = password;
         this.firstName = firstName;
     }

     public JCourier(String login, String password){
         this.login = login;
         this.password = password;
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
