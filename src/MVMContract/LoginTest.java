package MVMContract;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void login() {
        Customers customer = new Customers();
        Login login = new Login("John", "Doe", customer);

        // Create a list of customers
        Customers customers = new Customers();
        customers.addCustomer(new Customer("john", "password1", "john@example.com", "John Doe",
                LocalDate.of(1990, 1, 1)));
        customers.addCustomer(new Customer("jane", "password2", "jane@example.com", "Jane Smith",
                LocalDate.of(1995, 2, 15)));
        customers.addCustomer(new Customer("bob", "password3", "bob@example.com", "Bob Johnson",
                LocalDate.of(1985, 10, 20)));


        // Call the login method with valid credentials
        int resultValid = login.login();


        int expectedValidResult = 200;
        assertEquals(expectedValidResult, resultValid);

        int resultInvalid = login.login();

        int expectedInvalidResult = 401;
        assertEquals(expectedInvalidResult, resultInvalid);
    }
}