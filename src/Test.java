import java.util.List;

public class Test {
    public static void main(String[] args) {
        BookStore bookStore = BookStore.getInstance();


        Book book1 = new PaperBook("9780136520238",
                " ما وراء الطبيعة  - خالد توفيق ", 1000, 2009, 5);

        Book book2 = new PaperBook("9781478627777",
                "ارض زيكولا", 200, 2025, 3);

        Book book3 = new EBook("9780132774208",
                "Introduction to Java Programming and Data Structures ", 1500, 2000, "pdf");

        Book book4 = new EBook("9781284049190",
                "Introduction to Data Structures", 950, 2022, "pdf");

        Book book5 = new ShowBookCase("9780072322064", "Database Management Systems ", 1000, 2021);

        bookStore.addToInventory(book1);
        bookStore.addToInventory(book2);
        bookStore.addToInventory(book3);
        bookStore.addToInventory(book4);
        bookStore.addToInventory(book5);

        bookStore.buyBook("9780136520238", 1, "elkot@gmail.com", "Cairo, Egypt");
        bookStore.buyBook("9780132774208", 3, "elkot@gmail.com", "Cairo, Egypt");
        bookStore.buyBook("9781478627777", 2, "elkot@gmail.com", "Cairo, Egypt");
        bookStore.buyBook("9781284049190", 1, "elkot@gmail.com", "Cairo, Egypt");
//        bookStore.buyBook("9780072322064", 1, "elkot@gmail.com", "Cairo, Egypt");




        List<Book> removedBooks = bookStore.removeOutDatedBooks(10);
        System.out.println("****************************************");
        System.out.println("The booked removed: ");
        System.out.println(removedBooks);

    }

}