
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Library class for creating library objects. Library objects contain the following information:
 * - List of all books in the library
 *
 * @author Venzah Hamilton
 * @version 1.0
 */
public class Library {
    private List<Book> books = new ArrayList<>();
    private final String DELIMITER = ","; // Book information (title, author, and pub date) is separated by comma (,)
    private final int TITLE = 0;
    private final int AUTHOR = 1;
    private final int PUBLICATION_DATE = 2;

    /**
     * Loads books from a text file
     * @param fileName String of the name of the file to read from
     */
    public void loadBooks(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bookData = line.split(DELIMITER);
                books.add(new Book(bookData[TITLE], bookData[AUTHOR], Integer.parseInt(bookData[PUBLICATION_DATE])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints all books currently in the library
     */
    public void viewAllBooks() {
        System.out.println("\n--- Library Selection ---");
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    /**
     * Searches library and gathers books that contain the keyword specified
     * @param keyword String of word to search for
     * @return List of books whose title contains the specifed keyword
     */
    public List<Book> searchBookByKeyword(String keyword) {
        List <Book> foundBooks = new ArrayList<>();
        for(Book book : books) {
            if(book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    /**
     * Returns all the books in the library
     * @return List of books in the library
     */
    public List<Book> getBooks() { return books; }

    /**
     * Sets the list of books in the library
     * @param books List of books in the library
     */
    public void setBooks(List<Book> books) { this.books = books; }
}
