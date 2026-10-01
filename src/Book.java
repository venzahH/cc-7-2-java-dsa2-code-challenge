/**
 * Book class that contains constructor to create book objects. Book objects contain the following information:
 * - Title of the book
 * - Author of the book
 * - The year the book was published
 *
 * Users can do the following with book objects:
 * - Retrieve the title of a book
 * - Retrieve the author of a book
 * - Retrieve the year the book was published
 * - Set the title of a book
 * - Set the author of a book
 * - Set the year the book was published
 * - Print book objects
 *
 * @author Coursera
 * @version 1.0
 */

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private int publicationYear;

    /**
     * Constructor for book objects
     * @param title String of the title of the book
     * @param author String of the author of the book
     * @param publicationYear integer representation indicating the year the book was published
     */
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    /**
     * Returns the title of a book object
     * @return String of the title of the book
     */
    public String getTitle() { return title; }

    /**
     * Changes the title of a book object
     * @param title String of the new title of the book
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Returns the author of a book object
     * @return String of the author of the book
     */
    public String getAuthor() { return author; }

    /**
     * Changes the author of a book object
     * @param author String of the new author of the book
     */
    public void setAuthor(String author) { this.author = author; }

    /**
     * Returns the date the book object was published
     * @return integer indicating the year the book was published
     */
    public int getPublicationYear() { return publicationYear; }

    /**
     * Changes the year the book object was published
     * @param publicationYear integer indicating the new year the book was published
     */
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }

    /**
     * Formats how book objects will be printed
     * @return String of how book objects will be printed
     */
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
