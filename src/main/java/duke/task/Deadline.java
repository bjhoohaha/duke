package duke.task;

import duke.formatter.DateFormatter;
import duke.parser.DateParser;
import java.util.Date;

/**
 * A deadline item is a task with description and the date the deadline task is due by. The deadline item can be
 * created, marked as done or deleted.
 */
public class Deadline extends Task {

    /**
     * This is the date where the deadline task is due by.
     */
    private Date by;
    /**
     * Constructs a new deadline task with description and the date where the deadline task is due by that has not been
     * done.
     * @param description the description of the deadline task
     * @param by the date the task is due by
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = DateParser.parse(by);
    }

    /**
     * Constructs a new deadline task with description, the date where the deadline task is due by that has not been
     * done and the option to mark it as done.
     * @param description the description of the deadline task
     * @param by the date the task is due by
     * @param isDone the done status of the task
     */
    public Deadline(String description, Date by, boolean isDone) {
        super(description, isDone);
        this.by = by;
    }

    /**
     * Encodes the deadline task to be stored in the storage.
     * @return a string representation of the encoded deadline task
     */
    public String encode() {
        return "deadline," + super.isDone + "," + super.description + "," + DateFormatter.format(by);
    }

    /**
     * Returns a string representation of the deadline task. The string representation consist of ("[D]") with the string
     * representation of the task.
     * @return a string representation of the deadline task
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by:" + by + ")";
    }

}
