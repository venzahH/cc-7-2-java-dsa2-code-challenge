
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class contains implementations that can be used to sort books in the library. Three different types of sorts
 * are available:
 * - Bubble sort
 * - Insertion sort
 * - Quick sort
 *
 * @author Venzah Hamilton
 * @version 1.0
 */
public class SortUtil {

    /**
     * Uses bubble sort method to sort books in decending order by title, author, or publication date
     * @param books List of books to sort
     * @param comparator Comparator used to compare different properties of book objects
     */
    public static void bubbleSort(List<Book> books, Comparator<Book> comparator) {
        for(int i = 0; i < books.size() - 1; i++) {
            for(int j = 0; j < books.size(); j++) {
                if(comparator.compare(books.get(j), books.get(j + 1)) > 0) {
                    Collections.swap(books, j, j + 1);
                }
            }
        }
    }

    /**
     * Uses insertion sort method to sort books in decending order by title, author, or publication date
     * @param books List of books to sort
     * @param comparator Comparator used to compare different properties of book objects
     */
    public static void insertionSort(List<Book> books, Comparator<Book> comparator) {
        for (int i = 1; i < books.size(); i++) {
            Book key = books.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(books.get(j), key) > 0) {
                books.set(j + 1, books.get(j));
                j = j - 1;
            }
            books.set(j + 1, key);
        }
    }

    /**
     * Uses quick sort method to sort books in decending order by title, author, or publication date
     * @param books List of books to sort
     * @param comparator Comparator used to compare different properties of book objects
     * @param low integer representation of the smallest index in the list/sublist
     * @param high integer representation of the largest index in the list/sublist
     */
    public static void quickSort(List<Book> books, Comparator<Book> comparator, int low, int high) {
        if (low < high) {
            int pi = partition(books, comparator, low, high);
            quickSort(books, comparator, low, pi - 1);
            quickSort(books, comparator, pi + 1, high);
        }
    }

    /**
     * Partition method used in quick sort implementation.
     *
     * @param books List of books to sort
     * @param comparator Comparator used to compare different properties of book objects
     * @param low integer representation of the smallest index in the list/sublist
     * @param high integer representation of the largest index in the list/sublist
     * @return integer representation of the pivot's next position
     */
    private static int partition(List<Book> books, Comparator<Book> comparator, int low, int high) {
        Book pivot = books.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(books.get(j), pivot) <= 0) {
                i++;
                Collections.swap(books, i, j);
            }
        }
        Collections.swap(books, i + 1, high);
        return i + 1;
    }
}
