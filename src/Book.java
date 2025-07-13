public class Book {
    private String isbn;
    private String title;
    private double price;
    private int publishedYear;

    public Book(String isbn, String title, double price, int publishedYear) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.publishedYear = publishedYear;
    }

    public String getISBN() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    @Override
    public String toString() {
        return title;
    }



}