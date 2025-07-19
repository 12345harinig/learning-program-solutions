package TaskManagementSystem;

public class TaskManagerTest {
    public static void main(String[] args) {
        TaskLinkedList manager = new TaskLinkedList();

        // Add Tasks
        manager.addTask(new Task(1, "Design UI", "Pending"));
        manager.addTask(new Task(2, "Develop Backend", "In Progress"));
        manager.addTask(new Task(3, "Write Tests", "Not Started"));

        // List Tasks
        manager.listTasks();

        // Search Task
        Task task = manager.searchTask(2);
        System.out.println(task != null ? "Found: " + task : "Task not found.");

        // Delete Task
        manager.deleteTask(2);

        // List again
        manager.listTasks();
    }
}

