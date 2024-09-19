// Main class to demonstrate the Singleton Pattern
public class SingletonPatternExample {
    public static void main(String[] args) {
        // Get the single instance of ScheduleManager
        ScheduleManager manager1 = ScheduleManager.getInstance();
        manager1.displaySchedule();

        // Try to get another instance of ScheduleManager
        ScheduleManager manager2 = ScheduleManager.getInstance();
        manager2.displaySchedule();

        // Check if both instances are the same
        if (manager1 == manager2) {
            System.out.println("Both manager1 and manager2 are the same instance.");
        } else {
            System.out.println("manager1 and manager2 are different instances.");
        }
    }
}
