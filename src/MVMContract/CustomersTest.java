package MVMContract;



import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static org.junit.Assert.*;

public class CustomersTest {

    @Test
    public void removeCustomer() {
    }

    @Test
    public void write() {

        // Specify the file name for testing
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
            fail("Exception occurred during serialization/deserialization");
        }
    }

    @Test
    public void read() {
    }
}