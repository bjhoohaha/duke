package duke.task;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    public String encode() {
        return "todo," + super.description + "," + super.isDone;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}
