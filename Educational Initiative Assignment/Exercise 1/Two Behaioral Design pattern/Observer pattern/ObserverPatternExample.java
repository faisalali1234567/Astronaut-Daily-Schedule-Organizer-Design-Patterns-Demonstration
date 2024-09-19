import java.util.ArrayList;
import java.util.List;

// Define the Observer interface
interface Observer {
    void update(String message);
}

// Implement the Subject class
class TaskManager {
    private List<Observer> observers = new ArrayList<>();
    private List<String> tasks = new ArrayList<>();

    // Method to add an observer
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Method to add a task and notify observers if there's a conflict
    public void addTask(String task) {
        if (tasks.contains(task)) {
            notifyObservers("Task conflict detected: " + task);
        } else {
            tasks.add(task);
        }
    }

    // Method to notify all observers
    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// Implement the User class as an observer
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }
}

// Usage example
public class ObserverPatternExample {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        User user1 = new User("Alice");
        User user2 = new User("Bob");

        taskManager.addObserver(user1);
        taskManager.addObserver(user2);

        taskManager.addTask("Task 1");
        taskManager.addTask("Task 2");
        taskManager.addTask("Task 1"); // This will trigger a conflict notification
    }
}
