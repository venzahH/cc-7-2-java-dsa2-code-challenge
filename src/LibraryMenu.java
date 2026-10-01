
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * LibraryMenu class that contains constructor to create library menu objects. Library menu objects contain the following
 * information:
 * - Library object
 * - UserInteractionLogger object
 * - Library Serializer object
 *
 * Users can interact with the program's menu to display all books in the library, sort books by (author, title, or
 * publication date), or search for books by keywords
 *
 * @author Venzah Hamilton
 * @version 1.0
 */
public class LibraryMenu {
    private Library library;
    private UserInteractionLogger logger = new UserInteractionLogger();
    private LibrarySerializer serializer = new LibrarySerializer();  // Added serializer
    private final String LIBRARY_SERIALIZER_FILE = "src/resources/data/library.ser";
    private final String BOOK_FILE = "src/resources/data/books.txt";
    private final int DEFAULT_OPTION = -2;
    private final int QUIT = -1;

    /**
     * Upon creation of a library menu object, it checks to see if the library was serialized. If so, it returns the
     * library to its last saved state. If not, it loads books from a text file.
     * @param library Library object of the library the program will work with
     */
    public LibraryMenu(Library library) {
        this.library = library;

        // Load the library data when the program starts
        List<Book> books = serializer.loadLibrary(LIBRARY_SERIALIZER_FILE);
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully.");
        } else {
            System.out.println("No saved library found. Loading default books.");
            library.loadBooks(BOOK_FILE);
        }
    }

    /**
     * Displays menu for sorting and prompts user to select the way they'd like the books to be sorted.
     * @param scanner Scanner object to read user input
     * @return integer representation of the user's choice
     */
    public int sortMenu(Scanner scanner) {
        int sortOption = DEFAULT_OPTION;
        while(sortOption < -1 || sortOption > 3) {
            System.out.println("\nSelect a sort type or -1 to return to main menu");
            System.out.println("1. Sort by title");
            System.out.println("2. Sort by author");
            System.out.println("3. Sort by publication year");
            System.out.print("Choice: ");
            sortOption = scanner.nextInt();
            scanner.nextLine();
        }
        return sortOption;
    }

    /**
     * Displays menu for interacting with library and prompts user to select what they'd like to do.
     * @param scanner Scanner object to read user input
     * @return integer representation of the user's choice
     */
    public int mainMenu(Scanner scanner) {
        int mainOption = DEFAULT_OPTION;
        while(mainOption < -1 || mainOption > 3) {
            System.out.println("\n--- Select a number from the main menu or -1 to exit ---");
            System.out.println("1. View entire selection");
            System.out.println("2. Sort books");
            System.out.println("3. Search books");
            System.out.print("Choice: ");
            mainOption = scanner.nextInt();
            scanner.nextLine();
        }
        return mainOption;
    }

    /**
     * Displays menu for interacting with the library and is where method calls to perform specific tasks are done
     */
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to the Library Menu");
        int option = DEFAULT_OPTION;
        while(option != QUIT) {
            option = mainMenu(scanner);

            switch(option) {
                case 1: // Print all books in library
                    library.viewAllBooks();
                    logger.logViewAllBooks();
                    break;
                case 2: // Sort library books by title, author, or publication year
                    int sortOption = sortMenu(scanner);
                    switch(sortOption) {
                        case 1:
                            SortUtil.insertionSort(library.getBooks(), Comparator.comparing(Book::getTitle));
                            logger.logSort("title");
                            break;
                        case 2:
                            SortUtil.insertionSort(library.getBooks(), Comparator.comparing(Book::getAuthor));
                            logger.logSort("author");
                            break;
                        case 3:
                            SortUtil.insertionSort(library.getBooks(), Comparator.comparing(Book::getPublicationYear));
                            logger.logSort("publication year");
                            break;
                        default: // Case for when -1 is entered in which it returns to the main menu
                    }
                     break;
                case 3: // Search books by keyword
                    String searchKeyword;
                    System.out.print("\nEnter search keyword: ");
                    searchKeyword = scanner.next();
                    List<Book> foundBooks = library.searchBookByKeyword(searchKeyword);
                    System.out.println("--- Books containing '" + searchKeyword + "' ---");
                    for(Book book : foundBooks) {
                        System.out.println(book);
                    }
                    logger.logSearch(searchKeyword);
            }
        }
        serializer.saveLibrary(library.getBooks(), LIBRARY_SERIALIZER_FILE);
    }
}
