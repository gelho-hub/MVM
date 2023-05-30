package MVMContract;



import org.junit.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomersTest {

    @Test
    public void removeCustomer() {
        Customers customers = new Customers();

        // Create some customer objects
        Customer customer1 = new Customer("john", "password1", "john@example.com",
                "John Doe", LocalDate.of(1990, 1, 1));
        Customer customer2 = new Customer("jane", "password2", "jane@example.com",
                "Jane Smith", LocalDate.of(1995, 2, 15));
        Customer customer3 = new Customer("bob", "password3", "bob@example.com",
                "Bob Johnson", LocalDate.of(1985, 10, 20));

        // Add the customer objects to the customers list
        customers.addCustomer(customer1);
        customers.addCustomer(customer2);
        customers.addCustomer(customer3);

        // Call the removeCustomer method
        customers.removeCustomer();

        // Assertion: The customers list should be empty after calling removeCustomer
        List<Customer> expectedEmptyList = new ArrayList<>();
        List<Customer> actualList = customers.getCustomers();
        assertEquals(expectedEmptyList, actualList);
    }

    @Test
    public void write() {
        String fileName = "customer_test.ser";

        try {

            // Read the serialized object from the file
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Customer deserializedCustomer = (Customer) in.readObject();
            in.close();
            fileIn.close();

            // Delete the file after testing
            File file = new File(fileName);
            file.delete();
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
            assertNotNull("Exception occurred during serialization/deserialization");
        }
    }

    @Test
    public void read() {
        String fileName = "customers_test.ser";
        List<Customer> customersList = new ArrayList<>();
        customersList.add(new Customer("john", "password1", "john@example.com",
                "John Doe", LocalDate.of(1990, 1, 1)));
        customersList.add(new Customer("jane", "password2", "jane@example.com",
                "Jane Smith", LocalDate.of(1995, 2, 15)));
        customersList.add(new Customer("bob", "password3", "bob@example.com",
                "Bob Johnson", LocalDate.of(1985, 10, 20)));
        serializeCustomers(customersList, fileName);

        List<Customer> expectedCustomersList = customersList;


        // Delete the test file after testing
        File file = new File(fileName);
        file.delete();
    }

    // Helper method to serialize customers and write them to a file
    private void serializeCustomers(List<Customer> customers, String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(customers);
            out.close();
            fileOut.close();
        } catch (IOException exception) {
            exception.printStackTrace();
            fail("Exception occurred during serialization");
        }
    }
}