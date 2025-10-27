import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentServiceTest {
    private Date futureDate;
    private Appointment appointment;
    private AppointmentService service;

    @BeforeEach
    void setUp() {
        futureDate = new Date(System.currentTimeMillis() + 60000);
        appointment = new Appointment("12345", futureDate, "This is a description");
        service = new AppointmentService();
    }

    @Test
    void testAddAppointment() {
        assertTrue(service.addAppointment(appointment));
        assertNotNull(service.getAppointment("12345"));

        Appointment retrievedAppointment = service.getAppointment(appointment.getAppointmentId());

        assertEquals("12345", retrievedAppointment.getAppointmentId());
        assertEquals(futureDate, retrievedAppointment.getAppointmentDate());
        assertEquals("This is a description", retrievedAppointment.getAppointmentDesc());
    }

    @Test
    void testDeleteAppointment() {
        service.addAppointment(appointment);

        assertTrue(service.deleteAppointment("12345"));
        assertNull(service.getAppointment("12345"));
    }

    @Test
    void testDuplicateAppointmentId() {
        service.addAppointment(appointment);
        Appointment dupeAppointment = new Appointment("12345", futureDate, "This is a dupe");

        assertFalse(service.addAppointment(dupeAppointment));
    }

    @Test
    void testDeleteNotFoundId() {
        assertFalse(service.deleteAppointment("54321"));
    }

}
