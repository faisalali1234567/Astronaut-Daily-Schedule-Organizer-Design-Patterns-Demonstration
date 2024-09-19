import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScheduleManager manager = ScheduleManager.getInstance();

        while (true) {
            System.out.println("\nAstronaut Daily Schedule Organizer");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            switch (choice) {
                case 1:
                    // Add Task
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter start time (HH:MM): ");
                    LocalTime startTime = LocalTime.parse(scanner.nextLine());

                    System.out.print("Enter end time (HH:MM): ");
                    LocalTime endTime = LocalTime.parse(scanner.nextLine());

                    System.out.print("Enter priority (High, Medium, Low): ");
                    String priority = scanner.nextLine();

                    manager.addTask(description, startTime, endTime, priority);
                    break;

                case 2:
                    // Remove Task
                    System.out.print("Enter task description to remove: ");
                    String taskToRemove = scanner.nextLine();

                    if (manager.taskExists(taskToRemove)) {
                        manager.removeTask(taskToRemove);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 3:
                    // View All Tasks
                    manager.viewTasks();
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting application.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
