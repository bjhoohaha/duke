package duke.storage;

import duke.exception.FailedToSaveIOException;

import java.io.*;
import java.util.stream.Stream;

/**
 * This is the storage of the Duke Program. The storage is the <code>filePath</code> specified in the constructor of the
 * {@link duke.main.Duke} object. The <code>Storage</code> class loads and save the file into a stream of lines for
 * easy parsing into the list of tasks. See {@link duke.task.TaskList} for more information.
 */
public class Storage {
    /**
     * This is a string representation of the file path for storage.
     */
    private String filePath;

    /**
     * Constructs a new storage object using the specified file path.
     * @param filePath the path to the file for storage
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads the file and return a stream of lines inside the file.
     * @return a stream of lines inside the file
     * @throws IOException if an I/O error occurs
     */
    public Stream<String> load() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            return reader.lines();
        } catch(FileNotFoundException fnfe) {
            File file = new File("data/duke.txt");
            file.getParentFile().mkdirs();
            file.createNewFile();
            return Stream.empty();
        }
    }

    /**
     * Saves the stream of lines inside the file.
     * @param stream the stream of lines to be saved into the file
     * @throws IOException if an I/O error occurs
     */
    public void save(Stream<String> stream) throws FailedToSaveIOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            stream.forEach(line -> {
                try {
                    writer.write(line);
                } catch (IOException ioe) {
                    throw new UncheckedIOException(line, ioe);
                }
            });
            writer.close();
        } catch (FileNotFoundException fnfe) {
            try {
                File file = new File("data/duke.txt");
                file.getParentFile().mkdirs();
                file.createNewFile();
                save(stream);
            } catch (IOException ioex) {
                throw new FailedToSaveIOException();
            }
        } catch(IOException ioe) {
            throw new FailedToSaveIOException();
        } catch (UncheckedIOException uioe) {
            throw new FailedToSaveIOException(uioe.getMessage());
        }
    }

}
