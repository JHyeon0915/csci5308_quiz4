import java.util.List;

public class Member {
    private Long id;

    private String name;

    private List<Task> tasks;

    public List<Task> addTask(Task task) {
        tasks.add(task);
        return tasks;
    }

    public int getNumOfTasks() {
        return tasks.size();
    }
}
