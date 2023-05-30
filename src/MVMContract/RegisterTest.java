package MVMContract;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class RegisterTest {

    @Test
    public void register() {
        String input = "john@example.com\nJohn Doe\n1990, 01, 01\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Customers customer = new Customers();
        // Create an instance of the Register class
        Register register = new Register("John", "Doe", customer);

        // Call the register method
        int result = register.register();

        // Assertion: The result should be 200
        int expectedResult = 200;
        assertEquals(expectedResult, result);
    }
}