### How can I ensure that my code, program, or software is functional and secure?

Ensuring functionality begins with **thorough unit testing**. For each service (Contact, Task, Appointment), I created dedicated test suites that verified every requirement. This involved:
* **Testing the "Happy Path":** Ensuring the code works correctly with valid inputs (e.g., successfully adding a contact).
* **Testing the "Unhappy Path":** Critically verifying that the code correctly handles invalid inputs and edge cases (e.g., ensuring an `IllegalArgumentException` is thrown when attempting to create a Task with a `null` name, or when adding a Contact with a duplicate ID). The `assertThrows` and `assertFalse` assertions in JUnit were crucial for this.



* **Validation at Boundaries:** Implementing techniques like Boundary Value Analysis (testing phone numbers of length 9, 10, and 11) ensures robustness against common errors.

While this project didn't focus heavily on security, the same principles apply. **Input validation** (checking lengths, formats, non-null constraints) is the first line of defense against many security vulnerabilities like buffer overflows or injection attacks. Secure coding practices, followed by targeted security testing (e.g., penetration testing, vulnerability scanning - though not used here), would be necessary for production systems.

---
### How do I interpret user needs and incorporate them into a program?

Interpreting user needs starts with carefully analyzing the **software requirements document**. In these projects, the requirements for each class (like `Contact.java`) were treated as a direct blueprint for both the code and the tests.

1.  **Direct Translation:** Each requirement (e.g., "The contact ID shall not be null and shall not be updatable") was translated directly into code constructs (`private final String contactId;` and checks within the constructor).


2.  **Test Case Derivation (Black-Box Testing):** More importantly, each requirement was translated into specific test cases. I used a **black-box approach**, designing tests based *only* on the requirements, without looking at the implementation details. This ensures the tests verify what the *user needs*, not just what the code happens to do. For example, the requirement for a unique Task ID led directly to the `testAddTaskFailsWithDuplicateId` test.



3.  **Clarification (Implicit):** If requirements were ambiguous (though they weren't significantly in these projects), the process of writing tests often forces clarification. Trying to write an `assertEquals` requires knowing *exactly* what the output should be, pushing developers to resolve ambiguity early.





---
### How do I approach designing software?

My approach focuses on creating **simple, testable, and maintainable** components, often following Object-Oriented principles.

1.  **Separation of Concerns:** I designed distinct classes for data representation (`Contact`, `Task`, `Appointment`) and business logic (`ContactService`, `TaskService`, `AppointmentService`). This separation makes the code easier to understand, test, and modify. The data classes focused purely on holding data and enforcing its validity, while the service classes handled operations like adding and deleting.









2.  **Choosing Appropriate Data Structures:** For the service classes, I chose a `HashMap` to store the objects. This design decision was driven by the requirement for unique IDs and the need for efficient lookups, additions, and deletions (O(1) complexity), which supports scalability.



3.  **Test-Driven Thinking (Implicit):** Although not strictly TDD, I thought about *how* I would test the code as I designed it. For example, making the service methods return `boolean` (`true` for success, `false` for failure) makes them easily testable with `assertTrue` and `assertFalse`. Ensuring validation happened in constructors and setters made the data objects inherently testable with `assertThrows`. Designing for testability from the start leads to higher-quality, more reliable software.















4.  **Immutability where Possible:** For fields that shouldn't change (like `contactId`, `taskId`, `appointmentId`), I declared them `final`. For the `Appointment` class, since updates weren't required, I omitted setters entirely, making the object immutable after creation, which simplifies reasoning about the code and prevents bugs.

























