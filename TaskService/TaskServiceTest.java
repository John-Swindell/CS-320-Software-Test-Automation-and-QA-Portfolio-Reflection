import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    private TaskService service;
    private Task task;

    @BeforeEach
    void setUp() {
        service = new TaskService();
        task = new Task("12345", "Clean Bedroom", "Remove all trash and clutter");
    }

    @Test
    void testAddTask() {
        assertTrue(service.addTask(task));
        Task retrievedTask = service.getTask("12345");

        assertNotNull(retrievedTask);
        assertEquals("Clean Bedroom", retrievedTask.getName());
        assertEquals("Remove all trash and clutter", retrievedTask.getDescription());
    }

    @Test
    void testDeleteTask() {
        service.addTask(task);

        assertTrue(service.deleteTask("12345"));
        assertNull(service.getTask("12345"));
    }

    @Test
    void testUpdateTask() {
        service.addTask(task);

        Task retrievedTask = service.getTask("12345");
        service.updateTask("12345", "Random Task", "Random Task Description");

        assertEquals("Random Task", retrievedTask.getName());
        assertEquals("Random Task Description", retrievedTask.getDescription());
    }

    @Test
    void testAddTaskFailsWithDuplicateId() {
        service.addTask(task);
        Task dupeTask = new Task("12345", "Also Random Task", "Very Random Description");

        assertFalse(service.addTask(dupeTask));
    }

    @Test
    void testDeleteTaskNotFound() {
        assertFalse(service.deleteTask("54321"));
    }

    @Test
    void testUpdateTaskNotFound(){
        assertFalse(service.updateTask("54321", "Some Task", "Some Task Description"));
    }
}
