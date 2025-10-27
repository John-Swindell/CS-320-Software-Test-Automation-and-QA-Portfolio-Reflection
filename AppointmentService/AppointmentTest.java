import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentTest {
    private Date futureDate;

    @BeforeEach
    void setUp() {
        // System.currentTimeMillis gets the current time then 60000 adds a minute to that
        futureDate = new Date(System.currentTimeMillis() + 60000);
    }

    @Test
    void testAppointmentCreation() {
        Appointment appointment = new Appointment("12345", futureDate, "This is a description");

        assertTrue(appointment.getAppointmentId().equals("12345"));
        assertTrue(appointment.getAppointmentDate().equals(futureDate));
        assertTrue(appointment.getAppointmentDesc().equals("This is a description"));
    }

    @Test
    void testAppointmentIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "This is a description");
        });
    }

    @Test
    void testAppointmentIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "This is a description");
        });
    }

    @Test
    void testAppointmentDateInPast() {
        Date pastDate = new Date(System.currentTimeMillis() - 60000);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", pastDate, "This is a description");
        });
    }

    @Test
    void testAppointmentDateIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "This is a description");
        });
    }

    @Test
    void testAppointmentDescTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, "This appointment description is far too long and is well over 50 characters");
        });
    }

    @Test
    void testAppointmentDescIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, null);

        });
    }

}
