package MVMContract;

public class Login extends UserAction{
    public Login(String username, String password, Customers customers) {
        super(username, password, customers);
    }

    public int login(){
        if (!isUserRegistered()) {
            return 404;
        }
        for (Customer customer : customers.getCustomers()) {
            if (customer.getNickname().equals(customer.getNickname()) && customer.getPassword().equals(password)) {
                return 200;
            }
        }
        return 401;
    }

}
