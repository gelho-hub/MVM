package MVMContract;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class DateValidatorTest {

    @Test
    public void isValidDate() {

        DateValidator dateValidator = new DateValidator();

        // Test valid date format
        String validDate = "2023,05,29";
        assertTrue(dateValidator.isValidDate(validDate));

        // Test invalid date format
        String invalidDate = "2023-05-29";
        assertFalse(dateValidator.isValidDate(invalidDate));

        // Test invalid date with incorrect digits
        String invalidDateDigits = "2023,5,29";
        assertFalse(dateValidator.isValidDate(invalidDateDigits));

        // Test invalid date with incorrect separators
        String invalidDateSeparators = "2023.05.29";
        assertFalse(dateValidator.isValidDate(invalidDateSeparators));

        // Test invalid date with missing digits
        String invalidDateMissingDigits = "2023,,29";
        assertFalse(dateValidator.isValidDate(invalidDateMissingDigits));

        // Test invalid date with extra digits
        String invalidDateExtraDigits = "2023,05,290";
        assertFalse(dateValidator.isValidDate(invalidDateExtraDigits));
    }

    @Test
    public void checkDate() {
        DateValidator dateValidator = new DateValidator();


        String validDate = "2023,05,29";
        String invalidDate = "2023-05-29";


        String inputValidDate = validDate + "\n";
        InputStream inValidDate = new ByteArrayInputStream(inputValidDate.getBytes());
        System.setIn(inValidDate);

        String inputInvalidDate = invalidDate + "\n";
        InputStream inInvalidDate = new ByteArrayInputStream(inputInvalidDate.getBytes());
        System.setIn(inInvalidDate);


    }

    @Test
    public void splitDateElements() {
        DateValidator dateValidator = new DateValidator();

        // Prepare the necessary data for testing
        String[] validDateElements = {"2023", "05", "29"};
        String[] invalidDateElements = {"2023", "5", "29"};

        // Call the splitDateElements method with valid date elements
        LocalDate resultValidDate = dateValidator.splitDateElements(validDateElements);

        // Assertion 1: The returned LocalDate object should match the expected valid date
        assertEquals(LocalDate.of(2023, 5, 29), resultValidDate);


    }
}