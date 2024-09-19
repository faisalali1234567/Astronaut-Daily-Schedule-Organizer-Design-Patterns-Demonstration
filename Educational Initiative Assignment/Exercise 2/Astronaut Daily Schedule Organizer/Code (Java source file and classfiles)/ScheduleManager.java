import java.time.LocalTime;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;

    // Private constructor (Singleton pattern)
    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    // Singleton instance
    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    // Add a new task
    public void addTask(String description, LocalTime startTime, LocalTime endTime, String priority) {
        Task newTask = TaskFactory.createTask(description, startTime, endTime, priority);
        TaskObserver observer = new TaskObserver();
        observer.notifyConflict(newTask, this.tasks); // Notify about any conflicts
        tasks.add(newTask);
        System.out.println("Task added: " + description);
    }

    // Remove a task by description
    public void removeTask(String description) {
        tasks.removeIf(task -> task.getDescription().equals(description));
        System.out.println("Task removed: " + description);
    }

    // View all tasks sorted by start time
    public void viewTasks() {
        tasks.sort(Comparator.comparing(Task::getStartTime));
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    // Validate if any task exists by description
    public boolean taskExists(String description) {
        return tasks.stream().anyMatch(task -> task.getDescription().equals(description));
    }
}
