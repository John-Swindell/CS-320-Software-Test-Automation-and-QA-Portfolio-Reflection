import java.util.Date;

public class Appointment {
    // Final since ID should not change once assigned
    private final String appointmentId;
    private Date appointmentDate;
    private String appointmentDesc;

        public Appointment(String appointmentId, Date appointmentDate, String appointmentDesc) {

            if (appointmentId == null || appointmentId.length() > 10) { throw new IllegalArgumentException("Appointment ID must be between 1 and 10 characters."); }
            if (appointmentDate == null || appointmentDate.before(new Date())) { throw new IllegalArgumentException("Appointment cannot be in the past."); }
            if (appointmentDesc == null || appointmentDesc.length() > 50) { throw new IllegalArgumentException("Appointment description must be between 1 and 50 characters"); }

            this.appointmentId = appointmentId;
            this.appointmentDate = appointmentDate;
            this.appointmentDesc = appointmentDesc;
        }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentDesc() {
        return appointmentDesc;
    }
}


