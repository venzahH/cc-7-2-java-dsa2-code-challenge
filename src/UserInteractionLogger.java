
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Class that contains implementation for logging actions the user takes while interacting with the library
 */
public class UserInteractionLogger {

    private static final String LOG_FILE = "src/resources/data/user_interactions.log";
    private static final String SEPARATOR = " -- "; // Separates date and message in logs

    /**
     * Logs when the user searches for a book and what keyword was used
     * @param searchTerm String of the keyword the user used to search for books
     */
    public void logSearch(String searchTerm) {
        log("Search for: " + searchTerm);
    }

    /**
     * Logs when the user sorts the library and by what aspect (title, author, or publication date)
     * @param sortCriteria String of the criteria the book is sorted by (title, author, or publication date)
     */
    public void logSort(String sortCriteria) {
        log("Sorted by: " + sortCriteria);
    }

    /**
     * Logs when the user displays all books in the library
     */
    public void logViewAllBooks() {
        log("Viewed all books");
    }

    /**
     * Appends to log file the date and what action is performed on the library
     * @param message String indicating what the user did
     */
    public void log(String message) {
        try{
            LocalDateTime date = LocalDateTime.now();
            FileWriter fileWriter = new FileWriter(LOG_FILE, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(date + SEPARATOR + message);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e){
            System.out.println("Error writing to log file");
            System.out.println(e);
        }
    }
}
