public class TaskNode {

    String taskId;
    String description;
    boolean completed;
    TaskNode next;

    public TaskNode(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.completed = false;
        this.next = null;
    }
}