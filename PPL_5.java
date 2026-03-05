package ppl_lab;
class BookNotFoundException extends Exception {
   public BookNotFoundException(String message) { super(message); }
}
class InvalidReturnDateException extends Exception {
   public InvalidReturnDateException(String message) { super(message); }
}
class BookAlreadyCheckedOutException extends Exception {
   public BookAlreadyCheckedOutException(String message) { super(message); }
}
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
class Library {
   Book[] books;
   public Library(Book[] books) { this.books = books; }
   public Book findBook(String title) throws BookNotFoundException {
       for (Book book : books) {
           if (book.title.equalsIgnoreCase(title)) return book;
       }
       throw new BookNotFoundException("Book '" + title + "' not found in catalog.");
   }
   public void returnBook(String title, int daysLate) throws Exception {
       Book book = findBook(title);
       if (daysLate < 0) {
           throw new InvalidReturnDateException("Days late cannot be negative: " + daysLate);
       }
       book.isCheckedOut = false;
       System.out.println("Success: " + book.title + " returned.");
   }
   public void checkOutBook(String title) throws Exception {
       Book book = findBook(title);
       if (book.isCheckedOut) {
           throw new BookAlreadyCheckedOutException("'" + title + "' is already checked out.");
       }
       book.isCheckedOut = true;
       System.out.println("Success: " + title + " checked out.");
   }
}
public class prct5 {
   public static void main(String[] args) {
       Book[] books = {
           new Book(1, "Java Programming", false),
           new Book(2, "Python Programming", true),
           new Book(1, "JavaScript Programming", false),
           new Book(1, "C++ Programming", false),
       };
       Library library = new Library(books);
       System.out.println("--- Starting Exception Tests ---\n");
      
       try {
           System.out.println("Test 1: Searching for 'C++'...");
           library.findBook("C++");
       } catch (BookNotFoundException e) {
           System.out.println("CAUGHT: " + e.getMessage());
       }
       System.out.println("--------------------------------");
     
       try {
           System.out.println("Test 2: Checking out 'Python' (Already out)...");
           library.checkOutBook("Python Programming");
       } catch (Exception e) {
           System.out.println("CAUGHT: " + e.getMessage());
       }
       System.out.println("--------------------------------");
     
       try {
           System.out.println("Test 3: Returning 'Python Programming' with -5 days...");
           library.returnBook("Python Programming", -5);
       } catch (Exception e) {
           System.out.println("CAUGHT: " + e.getMessage());
       }
       System.out.println("\n--- All tests completed ---");
   }
}
