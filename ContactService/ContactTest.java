import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm Street");
        assertTrue(contact.getContactId().equals("12345"));
        assertTrue(contact.getFirstName().equals("John"));
    }

    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Elm Street");
        });
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "ThisNameIsWayTooLong", "Doe", "1234567890", "123 Elm Street");
        });
    }

    @Test
    void testLastNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Elm Street");
        });
    }

    @Test
    void testContactIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Elm Street");
        });
    }

    @Test
    void testFirstNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Elm Street");
        });
    }

    @Test
    void testLastNameIsTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "ThisLastNameIsWayTooLong", "1234567890", "123 Elm Street");
        });
    }

    @Test
    void testPhoneNumberIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null, "123 Elm Street");
        });
    }

    @Test
    void testPhoneNumberIsTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "123456789", "123 Elm Street");
        });
    }

    @Test
    void testPhoneNumberIsTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345678901", "123 Elm Street");
        });
    }

    @Test
    void testAddressIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", null);
        });
    }

    @Test
    void testAddressIsTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", "ThisAddressIsWayLongerThanThirtyCharacters");
        });
    }

}