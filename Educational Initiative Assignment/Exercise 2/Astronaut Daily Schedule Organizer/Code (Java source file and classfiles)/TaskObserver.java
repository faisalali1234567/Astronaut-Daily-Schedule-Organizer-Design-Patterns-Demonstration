import java.time.LocalTime;

import java.util.List;

public class TaskObserver {
    public void notifyConflict(Task newTask, List<Task> tasks) {
        for (Task task : tasks) {
            if (newTask.overlapsWith(task)) {
                System.out.println("Conflict with existing task: " + task.getDescription());
            }
        }
    }
}
