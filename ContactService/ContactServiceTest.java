import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm Street");
    }

    @Test
    void testAddContact() {
        assertTrue(service.addContact(contact));
        Contact retrievedContact = service.getContact("12345");

        assertNotNull(retrievedContact);
        assertEquals("John", retrievedContact.getFirstName());
        assertEquals("Doe", retrievedContact.getLastName());
        assertEquals("1234567890", retrievedContact.getNumber());
        assertEquals("123 Elm Street", retrievedContact.getAddress());
    }

    @Test
    void testDeleteContact() {
        service.addContact(contact);
        assertTrue(service.deleteContact("12345"));
        assertNull(service.getContact("12345"));
    }

    @Test
    void testUpdateContact() {
        service.addContact(contact);
        Contact retrievedContact = service.getContact("12345");

        service.updateContact(retrievedContact.getContactId(), "Jane", "Smith", "0987654321", "123 Real Road");
        assertEquals("Jane", retrievedContact.getFirstName());
        assertEquals("Smith", retrievedContact.getLastName());
        assertEquals("0987654321", retrievedContact.getNumber());
        assertEquals("123 Real Road", retrievedContact.getAddress());
    }

    @Test
    void testAddContactFailsWithDuplicateId() {
        service.addContact(contact);
        Contact dupeContact = new Contact("12345", "Peter", "Parker", "5555555555", "456 Forest Hills");
        assertFalse(service.addContact(dupeContact));
    }

    @Test
    void testDeleteContactNotFound() {
        assertFalse(service.deleteContact("54321"));
    }

    @Test
    void testUpdateContactNotFound() {
        assertFalse(service.updateContact("54321", "Bruce", "Wayne", "4444444444", "789 Bat Lane"));
    }
}