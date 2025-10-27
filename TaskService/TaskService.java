import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    public boolean addTask(Task task) {
        if (task == null || tasks.containsKey(task.getTaskId())) {
            return false;
        } else {
            tasks.put(task.getTaskId(), task);
            return true;
        }
    }

    public boolean deleteTask(String taskId) {
        if (taskId == null || !tasks.containsKey(taskId)) {
            return false;
        } else {
            tasks.remove(taskId);
            return true;
        }
    }

    public boolean updateTask(String taskId, String name, String description) {
        if (taskId == null || !tasks.containsKey(taskId)) {
            return false;
        } else {
            Task retrievedTask = tasks.get(taskId);
            retrievedTask.setName(name);
            retrievedTask.setDescription(description);
            return true;
        }
    }

    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
