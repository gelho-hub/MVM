package MVMContract;

public abstract class UserAction {
    protected String username;
    protected String password;
    protected Customers customers;

    public UserAction(String username, String password, Customers customers) {
        this.username = username;
        this.password = password;
        this.customers = customers;
    }
    public boolean isUserRegistered(){
        return (customers.isCustomerAdded(username)) ? true : false;
    }
}
