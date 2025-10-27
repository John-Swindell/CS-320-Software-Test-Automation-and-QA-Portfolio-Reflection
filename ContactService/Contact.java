public class Contact {
    // contactId is final because it cannot be changed after its assignment
    private final String contactId;
    private String firstName;
    private String lastName;
    private String number;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String number, String address) {
        if (contactId == null || contactId.length() > 10) { throw new IllegalArgumentException("Contact ID must be between 1 and 10 characters"); }
        if (firstName == null || firstName.length() > 10) { throw new IllegalArgumentException("First name must be between 1 and 10 characters"); }
        if (lastName == null || lastName.length() > 10) { throw new IllegalArgumentException("Last name must be between 1 and 10 characters"); }
        if (number == null || number.length() != 10) { throw new IllegalArgumentException("Number must be exactly 10 characters"); }
        if (address == null || address.length() > 30) { throw new IllegalArgumentException("Address must be between 1 and 30 characters"); }

        // All assignments
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.address = address;
    }

    // Getters for all fields
    public String getContactId() {
        return contactId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getNumber() {
        return number;
    }
    public String getAddress() {
        return address;
    }

    // Setters for all fields
    public void setFirstName(String name) {
        if (name == null || name.length() > 10) { throw new IllegalArgumentException("First name cannot be null or longer than 10 characters."); }
        this.firstName = name;
    }
    public void setLastName(String secondName) {
        if (secondName == null || secondName.length() > 10) { throw new IllegalArgumentException("Last name cannot be null or longer than 10 characters."); }
        this.lastName = secondName;
    }
    public void setNumber(String number) {
        if (number == null || number.length() != 10) { throw new IllegalArgumentException("Phone number must be exactly 10 digits."); }
        this.number = number;
    }
    public void setAddress(String address) {
        if (address == null || address.length() > 30) { throw new IllegalArgumentException("Address cannot be null or longer than 30 characters."); }
        this.address = address;
    }

}