import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public boolean addContact(Contact contact) {
        // Check if the contact or its ID is null
        if (contact == null || contact.getContactId() == null) { return false; }
        // Check if the key already exists in map
        if (contacts.containsKey(contact.getContactId())) {
            return false; // Failure
        } else {
            contacts.put(contact.getContactId(), contact);
            return true; // Success
        }
    }

    public boolean deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            // Check if contactId passed is null or not in the map
            return false;
        } else {
            contacts.remove(contactId);
            return true;
        }
    }
    public boolean updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            // Check if contactId passed is null or not in the map
            return false;
    } else {
            Contact currContact = contacts.get(contactId);
            if (firstName != null) {
                currContact.setFirstName(firstName);
            }
            if (lastName != null) {
                currContact.setLastName(lastName);
            }
            if (phoneNumber != null) {
                currContact.setNumber(phoneNumber);
            }
            if (address != null) {
                currContact.setAddress(address);
            }
        return true;
        }
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}

