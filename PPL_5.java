package javapr;

import java.util.Scanner;

// Custom Exceptions
class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}

class InvalidReturnDateException extends Exception {
    public InvalidReturnDateException(String message) {
        super(message);
    }
}

class BookAlreadyCheckedOutException extends Exception {
    public BookAlreadyCheckedOutException(String message) {
        super(message);
    }
}

class BookNotIssuedException extends Exception {
    public BookNotIssuedException(String message) {
        super(message);
    }
}

// Book Class
class Book {
    int bookid;
    String title;
    boolean isCheckedOut;

    Book(int bookid, String title, boolean isCheckedOut) {
        this.bookid = bookid;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
    }
}

// Library Class
class Library {

    Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public Book findBook(String title) throws BookNotFoundException {

        for (Book book : books) {

            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }

        throw new BookNotFoundException("Book not found!");
    }

    public void checkOutBook(String title)
            throws BookNotFoundException, BookAlreadyCheckedOutException {

        Book book = findBook(title);

        if (book.isCheckedOut) {
            throw new BookAlreadyCheckedOutException("Book already checked out!");
        }

        book.isCheckedOut = true;

        System.out.println("Book issued successfully.");
    }

    public void returnBook(String title, int daysLate)
            throws BookNotFoundException,
            InvalidReturnDateException,
            BookNotIssuedException {

        Book book = findBook(title);

        if (daysLate < 0) {
            throw new InvalidReturnDateException("Invalid return days!");
        }

        if (!book.isCheckedOut) {
            throw new BookNotIssuedException("Book was not issued!");
        }

        book.isCheckedOut = false;

        int fine = 0;

        if (daysLate > 0) {

            fine = daysLate * 5;

            System.out.println("Book returned successfully.");
            System.out.println("Late fine: Rs." + fine);

        } else {

            System.out.println("Book returned successfully.");
            System.out.println("No fine.");
        }
    }

    public void displayBooks() {

        for (Book b : books) {

            System.out.println(
                    b.title + " - " +
                    (b.isCheckedOut ? "Issued" : "Available"));
        }
    }
}

// Main Class
public class prct5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Book[] books = {
                new Book(1, "Java Programming", false),
                new Book(2, "Python Programming", true),
                new Book(3, "JavaScript Programming", false),
                new Book(4, "C++ Programming", false)
        };

        Library library = new Library(books);

        int choice;

        do {

            System.out.println("\n1. Search Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Enter title: ");
                        String t1 = sc.nextLine();

                        library.findBook(t1);

                        System.out.println("Book found!");

                        break;

                    case 2:

                        System.out.print("Enter title: ");
                        String t2 = sc.nextLine();

                        library.checkOutBook(t2);

                        break;

                    case 3:

                        System.out.print("Enter title: ");
                        String t3 = sc.nextLine();

                        System.out.print("Enter late days: ");

                        int days = sc.nextInt();

                        library.returnBook(t3, days);

                        break;

                    case 4:

                        library.displayBooks();

                        break;

                    case 5:

                        System.out.println("Exiting...");

                        break;

                    default:

                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);

        sc.close();
    }
}
