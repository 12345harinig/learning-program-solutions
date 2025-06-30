package TaskManagementSystem;

public class TaskLinkedList {
    private TaskNode head;

    // Add task at the end
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Task added: " + task);
    }

    // Search task by ID
    public Task searchTask(int id) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId() == id) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse all tasks
    public void listTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("All Tasks:");
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete task by ID
    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.task.getTaskId() == id) {
            head = head.next;
            System.out.println("Task with ID " + id + " deleted.");
            return;
        }

        TaskNode current = head;
        while (current.next != null && current.next.task.getTaskId() != id) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task with ID " + id + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Task with ID " + id + " deleted.");
        }
    }
}

