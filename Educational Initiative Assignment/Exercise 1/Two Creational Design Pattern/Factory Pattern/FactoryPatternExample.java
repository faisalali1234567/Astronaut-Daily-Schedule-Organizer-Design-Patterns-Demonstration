// Step 1: Define the Task class (base class for all tasks)
abstract class Task {
    String name;
    String priority;

    public Task(String name, String priority) {
        this.name = name;
        this.priority = priority;
    }

    // Abstract method to describe the task
    public abstract void describeTask();
}

// Step 2: Create specific task types (e.g., HighPriorityTask and LowPriorityTask)

// High Priority Task class
class HighPriorityTask extends Task {
    public HighPriorityTask(String name) {
        super(name, "High");
    }

    @Override
    public void describeTask() {
        System.out.println("Task: " + name + " [Priority: " + priority + "]");
    }
}

// Low Priority Task class
class LowPriorityTask extends Task {
    public LowPriorityTask(String name) {
        super(name, "Low");
    }

    @Override
    public void describeTask() {
        System.out.println("Task: " + name + " [Priority: " + priority + "]");
    }
}

// Step 3: Create the TaskFactory class

class TaskFactory {
    // Factory method to create tasks based on priority
    public static Task createTask(String name, String priority) {
        if (priority.equalsIgnoreCase("High")) {
            return new HighPriorityTask(name);
        } else if (priority.equalsIgnoreCase("Low")) {
            return new LowPriorityTask(name);
        } else {
            throw new IllegalArgumentException("Unknown priority: " + priority);
        }
    }
}

// Step 4: Main class to demonstrate the Factory Pattern
public class FactoryPatternExample {
    public static void main(String[] args) {
        // Create tasks using the TaskFactory
        Task task1 = TaskFactory.createTask("Complete Assignment", "High");
        Task task2 = TaskFactory.createTask("Watch Movie", "Low");

        // Describe the tasks
        task1.describeTask();
        task2.describeTask();
    }
}

