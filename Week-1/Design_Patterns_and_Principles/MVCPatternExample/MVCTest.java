package MVCPatternExample;

public class MVCTest {
    public static void main(String[] args) {
        // Create the model
        Student student = new Student("Harini G", "CSE1023", "A");

        // Create the view
        StudentView view = new StudentView();

        // Create the controller
        StudentController controller = new StudentController(student, view);

        // Display initial data
        controller.updateView();

        // Update model via controller
        controller.setStudentGrade("A+");
        controller.setStudentName("Hari");

        // Display updated data
        controller.updateView();
    }
}

