    import Exception.InvalidYearException;
    import Exception.DuplicateBookException;
    import Exception.BookNotFoundException;

    import java.util.List;

    public class Main {
        public static void main(String[] args) {
            Library library = new Library();

            try {
                library.addBook(EnumBooksLib.Book1.getTitle(), EnumBooksLib.Book1.getAuthor(),
                        EnumBooksLib.Book1.getYear(), EnumBooksLib.Book1.getIsbn());
                library.addBook(EnumBooksLib.Book2.getTitle(), EnumBooksLib.Book2.getAuthor(),
                        EnumBooksLib.Book2.getYear(), EnumBooksLib.Book2.getIsbn());
                library.addBook(EnumBooksLib.Book3.getTitle(), EnumBooksLib.Book3.getAuthor(),
                        EnumBooksLib.Book3.getYear(), EnumBooksLib.Book3.getIsbn());
                library.addBook(EnumBooksLib.Book4.getTitle(), EnumBooksLib.Book4.getAuthor(),
                        EnumBooksLib.Book4.getYear(), EnumBooksLib.Book4.getIsbn());
            } catch (DuplicateBookException | InvalidYearException e) {
                System.out.println("Error " + e.getMessage());
            }
            try {
                Book booksByIsbn = library.findBookByIsbn("ISBN4");
                System.out.println("Book found: " + booksByIsbn.getTitle());

                List<Book> findBookByAuthor = library.findBookByAuthor("Author3");
                for (Book b : findBookByAuthor) {
                    System.out.println("Book found: " + b.getTitle());
                }

                List<Book> findBookByYear = library.findBookByYear(2022);
                for(Book b : findBookByYear) {
                    System.out.println("Book found: " + b.getTitle());
                }
            } catch (BookNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }