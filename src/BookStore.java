import java.time.Year;
import java.util.ArrayList;
import java.util.List;


public class BookStore {
    private static BookStore instance;

    private ArrayList<Book> inventory = new ArrayList<>();

    private BookStore() {}

    // apply the singleton design Pattern
    public static BookStore getInstance() {
        if (instance == null) {
            instance = new BookStore();
        }

        return instance;
    }

    public void addToInventory(Book book) {
        inventory.add(book);
    }

    public List<Book> removeOutDatedBooks(int yearsPassed) {
        List<Book> outDatedBooks = new ArrayList<>();

        for (Book book: inventory) {
            if (Year.now().getValue() - book.getPublishedYear() >= yearsPassed) {
                outDatedBooks.add(book);
            }
        }

        outDatedBooks.forEach(book -> inventory.remove(book));

        return outDatedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {

        Book theBook = getBookByISBN(isbn);

        if (theBook instanceof ShowBookCase) {
            throw new IllegalArgumentException("Cannot buy a book : " + theBook.getTitle());
        }

        if (theBook instanceof EBook) {

            EBook tempBook = (EBook)theBook;
            tempBook.sendViaEmail(email);

            return quantity * theBook.getPrice();
        }

        PaperBook tempBook = (PaperBook)theBook;

        if (quantity > tempBook.getNumberInStock()) {
            throw new IllegalArgumentException("The quantity you order is out of the stock");
        }

        tempBook.sendToShippingService(address);
        tempBook.decreaseStock(quantity);

        return quantity * theBook.getPrice();
    }

    private Book getBookByISBN(String isbn) {
        Book theBook = null;

        for(Book book: inventory) {
            if (book.getISBN().equals(isbn)) {
                theBook = book;
                break;
            }
        }

        if (theBook == null) {
            throw new IllegalArgumentException("Cannot found a book with isbn: "+ isbn);
        } else {
            return theBook;
        }
    }
}