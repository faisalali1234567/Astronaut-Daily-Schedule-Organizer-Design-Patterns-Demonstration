// Base Task class
abstract class Task {
    String name;
    String priority;

    public Task(String name, String priority) {
        this.name = name;
        this.priority = priority;
    }

    public abstract void describeTask();
}

// Concrete Task classes
class HighPriorityTask extends Task {
    public HighPriorityTask(String name) {
        super(name, "High");
    }

    @Override
    public void describeTask() {
        System.out.println("Task: " + name + " [Priority: " + priority + "]");
    }
}

class LowPriorityTask extends Task {
    public LowPriorityTask(String name) {
        super(name, "Low");
    }

    @Override
    public void describeTask() {
        System.out.println("Task: " + name + " [Priority: " + priority + "]");
    }
}

// Decorator base class
abstract class TaskDecorator extends Task {
    protected Task decoratedTask;

    public TaskDecorator(Task task) {
        super(task.name, task.priority);
        this.decoratedTask = task;
    }

    @Override
    public void describeTask() {
        decoratedTask.describeTask();
    }
}

// Concrete Decorators
class CompletedTaskDecorator extends TaskDecorator {
    public CompletedTaskDecorator(Task task) {
        super(task);
    }

    @Override
    public void describeTask() {
        decoratedTask.describeTask();
        System.out.println("Status: Completed");
    }
}

class TaggedTaskDecorator extends TaskDecorator {
    private String tag;

    public TaggedTaskDecorator(Task task, String tag) {
        super(task);
        this.tag = tag;
    }

    @Override
    public void describeTask() {
        decoratedTask.describeTask();
        System.out.println("Tags: " + tag);
    }
}

// Main class to demonstrate the Decorator Pattern
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Create a basic high priority task
        Task highPriorityTask = new HighPriorityTask("Complete Assignment");

        // Decorate the task with completion status
        Task completedTask = new CompletedTaskDecorator(highPriorityTask);
        completedTask.describeTask();

        // Further decorate the completed task with a tag
        Task taggedTask = new TaggedTaskDecorator(completedTask, "Urgent");
        taggedTask.describeTask();
    }
}
