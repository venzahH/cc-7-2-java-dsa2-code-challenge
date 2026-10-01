/**
 * Main class that contains source code
 * @author Venzah Hamilton
 * @version 1.0
 */
public class Main {
    /**
     * Main method that will create a new library and library menu. The rest of the interactions occur in the
     * LibraryMenu's displayMenu method
     *
     * @param args String array containing arguments passed when running file in terminal
     */
    public static void main(String[] args) {
        Library library = new Library();
        LibraryMenu libraryMenu = new LibraryMenu(library);
        libraryMenu.displayMenu();
    }
}
