import java.util.Date;

public class Task {
    private String name;

    private String description;

    private String status;

    private Date estimatedCompletionDate;

    /**
     *
     * Constructs with all arguments
     *
     * @param name
     * @param description
     * @param status
     * @param estimatedCompletionDate
     */
    public Task(String name, String description, String status, Date estimatedCompletionDate) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.estimatedCompletionDate = estimatedCompletionDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Member assignTo(Member member) {
        member.addTask(Task.this);
        return member;
    }

    public Task updateStatus(String status) {
        if (status.equals("Waiting")|| status.equals("In Progress") || status.equals("Completed")) {
            setStatus(status);
        }

        return Task.this;
    }

    public boolean isOverDue() {
        return new Date(System.currentTimeMillis()).after(estimatedCompletionDate);
    }
}
