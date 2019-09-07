package duke.command;

import duke.main.Launcher;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;
import javafx.application.Application;

public class LaunchCommand implements Command {

    String[] args;

    public LaunchCommand(String[] args) {
        this.args = args;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Application.launch(Launcher.class, args);
    }

    public boolean isExit() {
        return false;
    }
}