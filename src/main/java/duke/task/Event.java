package duke.task;

import duke.formatter.DateFormatter;
import duke.parser.DateParser;
import java.util.Date;

/**
 * A event item is a task with description and the date the event will be held at. The event item can be created,
 * marked as done or deleted.
 */
public class Event extends Task {

    /**
     * This is the date where the event will be held at.
     */
    private Date at;

    /**
     * Constructs a new event task with description and the date the event will be held at that has not been done.
     * @param description the description of the event task
     * @param at the date the event will be held at
     */
    public Event(String description, String at) {
        super(description);
        this.at = DateParser.parse(at);
    }

    /**
     * Constructs a new event task with description,the date the event will be held at that has not been done and the
     * option to mark it as done.
     * @param description the description of the event task
     * @param at the date the event will be held at
     * @param isDone the done status of the task
     */
    public Event(String description, Date at, boolean isDone) {
        super(description, isDone);
        this.at = at;
    }

    /**
     * Encodes the event task to be stored in the storage.
     * @return a string representation of the encoded event task
     */
    public String encode() {
        return "event," + super.description + "," + super.isDone + "," + DateFormatter.format(at);
    }

    /**
     * Returns a string representation of the event task. The string representation consist of ("[E]") with the string
     * representation of the task.
     * @return a string representation of the event task
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at:" + at + ")";
    }

}
