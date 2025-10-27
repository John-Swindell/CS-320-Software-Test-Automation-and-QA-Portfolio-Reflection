import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    void testTaskCreation() {
        Task task = new Task("12345", "Clean Bedroom", "Remove all trash and clutter");

        assertTrue(task.getTaskId().equals("12345"));
        assertTrue(task.getName().equals("Clean Bedroom"));
        assertTrue(task.getDescription().equals("Remove all trash and clutter"));
    }

    @Test
    void testTaskIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Clean Bedroom", "Remove all trash and clutter");
        });
    }

    @Test
    void testTaskIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Clean Bedroom", "Remove all trash and clutter");
        });
    }

    @Test
    void testTaskNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "ThisTaskNameMustBeWayTooLongToWork", "Remove all trash and clutter");
        });
    }

    @Test
    void testTaskNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", null, "Remove all trash and clutter");
        });
    }

    @Test
    void testTaskDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Clean Bedroom", "ThisTaskDescriptionMustBeReallyReallyLongToEnsureItDoesNotWork");
        });
    }

    @Test
    void testTaskDescriptionIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Clean Bedroom", null);
        });
    }

}
