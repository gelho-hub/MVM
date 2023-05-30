package MVMContract;

import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class InvoiceTest {

    @org.junit.Test
    public void createInvoiceID() {
        // Create a sample customer
        Customer owner = new Customer("John Doe"); // Replace "John Doe" with the actual customer name

        // Create a sample date of issue
        LocalDate dateOfIssue = LocalDate.of(2023, 5, 29); // Replace with the desired date

        // Create an instance of the Invoice class
        Invoice invoice = new Invoice();

        // Call the method to be tested
        String invoiceID = invoice.createInvoiceID(dateOfIssue);

        // Perform assertions to verify the expected behavior

        // Assertion 1: Az Invoice ID nem lehet null
        assertNotNull(invoiceID);

        // Assertion 3: The invoice ID should contain the day, month, and year of issue
        assertTrue(invoiceID.contains(String.valueOf(dateOfIssue.getDayOfMonth())));
        assertTrue(invoiceID.contains(String.valueOf(dateOfIssue.getMonthValue())));
        assertTrue(invoiceID.contains(String.valueOf(dateOfIssue.getYear())));
    }

    @org.junit.Test
    public void read() {
        String fileName = "sample_invoice.ser"; // Replace with the actual file name

        // Create an instance of the Invoice class
        Invoice invoice = new Invoice();



    }

    @org.junit.Test
    public void delayedPayment() {
    }

    @org.junit.Test
    public void createNewInvoice() {
    }
}