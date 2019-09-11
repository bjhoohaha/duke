package duke.command;

import duke.exception.InvalidDateTimeException;
import duke.exception.InvalidParameterException;
import duke.task.Deadline;

/**
 * The <code>AddDeadlineCommand</code> is created when the user enters <code>"deadline"</code>. The todo command add a \
 * deadline task into the list of tasks in {@link duke.task.TaskList}. The user interface will display the new deadline
 * task that is added.
 */
public class AddDeadlineCommand extends AddCommand {

    /**
     * Constructs a new add deadline command that will be executed in the <code>run</code> method of
     * {@link duke.main.Duke} with the specified line as a parameter.
     * @param line the line contents of the command passed as a parameter
     * @throws InvalidParameterException if the line is blank
     */
    public AddDeadlineCommand(String line) throws InvalidParameterException {
        super(line);
        if(line.isBlank()) {
            throw new InvalidParameterException();
        }
        try {
            String[] arr = super.line.split(" /by ");
            String taskDescription = arr[0];
            String deadlineBy = arr[1];
            super.task = new Deadline(taskDescription, deadlineBy);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            throw new InvalidParameterException(line);
        } catch(InvalidDateTimeException idte) {
            throw new InvalidParameterException(idte.getInvalidDateTime());
        }
    }

}
