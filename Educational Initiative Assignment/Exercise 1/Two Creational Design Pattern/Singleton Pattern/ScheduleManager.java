// Singleton ScheduleManager class
public class ScheduleManager {
    // Step 1: Create a private static instance of the class
    private static ScheduleManager instance;

    // Step 2: Private constructor to prevent instantiation from outside the class
    private ScheduleManager() {
        System.out.println("ScheduleManager instance created.");
    }

    // Step 3: Public method to provide access to the single instance
    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();  // Create the instance if it doesn't exist
        }
        return instance;  // Return the single instance
    }

    // Example method for demonstration
    public void displaySchedule() {
        System.out.println("Displaying the task schedule.");
    }
}

