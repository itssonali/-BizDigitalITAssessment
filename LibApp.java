import java.util.*;

class Book {
    int id;
    String title;
    String author;
    String isbn;
    boolean available;

    public Book(int id, String title, String author, String isbn, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
    }

    public String toString() {
        return "[" + id + "] " + title + " by " + author + ", ISBN: " + isbn + ", Available: " + available;
    }
}

public class LibraryApp {
    static Map<Integer, Book> bookCatalog = new HashMap<>();

    public static void addBook(Book book) {
        bookCatalog.put(book.id, book);
        System.out.println("Book added!");
    }

    public static void getAllBooks() {
        for (Book b : bookCatalog.values()) {
            System.out.println(b);
        }
    }

    public static void getBookById(int id) {
        Book b = bookCatalog.get(id);
        System.out.println(b != null ? b : "Book not found");
    }

    public static void updateAvailability(int id, boolean status) {
        if (bookCatalog.containsKey(id)) {
            bookCatalog.get(id).available = status;
            System.out.println("Book availability updated");
        } else {
            System.out.println("Book not found");
        }
    }

    public static void deleteBook(int id) {
        if (bookCatalog.remove(id) != null) {
            System.out.println("Book deleted");
        } else {
            System.out.println("Book not found");
        }
    }

    public static void main(String[] args) {
       
        addBook(new Book(1, "Java Basics", "James Gosling", "ISBN001", true));
        addBook(new Book(2, "OOP in Java", "Sun Micro", "ISBN002", true));

        getAllBooks();
        getBookById(1);
        updateAvailability(1, false);
        deleteBook(2);
        getAllBooks();
    }
}
