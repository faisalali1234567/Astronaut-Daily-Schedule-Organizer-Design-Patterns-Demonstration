import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Task class to represent a task with start time and priority
class Task {
    String name;
    String startTime; // e.g., "09:00"
    int priority;     // Higher number means higher priority

    public Task(String name, String startTime, int priority) {
        this.name = name;
        this.startTime = startTime;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", startTime='" + startTime + '\'' +
                ", priority=" + priority +
                '}';
    }
}

// Step 1: Define the SortStrategy interface
interface SortStrategy {
    void sort(List<Task> tasks);
}

// Step 2: Implement SortByPriority class
class SortByPriority implements SortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        // Sort by priority (higher priority first)
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return Integer.compare(t2.priority, t1.priority); // Descending order
            }
        });
    }
}

// Step 3: Implement SortByStartTime class
class SortByStartTime implements SortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        // Sort by start time (earlier time first)
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.startTime.compareTo(t2.startTime); // Ascending order
            }
        });
    }
}

// TaskManager class to manage tasks and apply sorting strategies
class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private SortStrategy sortStrategy; // Current sorting strategy

    // Method to add tasks to the list
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Method to set the sorting strategy
    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    // Method to sort tasks based on the chosen strategy
    public void sortTasks() {
        if (sortStrategy != null) {
            sortStrategy.sort(tasks);
        }
    }

    // Method to display tasks
    public void displayTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}

// Main class to demonstrate the Strategy Pattern
public class StrategyPatternExample {
    public static void main(String[] args) {
        // Create a TaskManager instance
        TaskManager taskManager = new TaskManager();

        // Add some tasks with different priorities and start times
        taskManager.addTask(new Task("Task 1", "09:00", 1));
        taskManager.addTask(new Task("Task 2", "08:30", 3));
        taskManager.addTask(new Task("Task 3", "10:00", 2));

        // Sort by priority
        System.out.println("Sorting by Priority:");
        taskManager.setSortStrategy(new SortByPriority()); // Set sorting strategy to SortByPriority
        taskManager.sortTasks();  // Apply sorting
        taskManager.displayTasks(); // Display sorted tasks

        // Sort by start time
        System.out.println("\nSorting by Start Time:");
        taskManager.setSortStrategy(new SortByStartTime()); // Set sorting strategy to SortByStartTime
        taskManager.sortTasks();  // Apply sorting
        taskManager.displayTasks(); // Display sorted tasks
    }
}
