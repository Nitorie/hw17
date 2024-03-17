import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Exception.InvalidYearException;
import Exception.DuplicateBookException;
import Exception.BookNotFoundException;


public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author, int year, String isbn) throws DuplicateBookException, InvalidYearException {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                throw new DuplicateBookException("Book with ISBN " + isbn + " already exists.");
            }
        }
        if (year < 0 || year > Calendar.getInstance().get(Calendar.YEAR)) {
            throw new InvalidYearException("Invalid Year " + year);
        }
        books.add(new Book(title,author,year,isbn));
    }

    public void removeBook(String isbn) throws BookNotFoundException {
        boolean removed = false;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                removed = true;
                break;
            }
        }
        if (!removed) {
            throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
        }
    }

    public List<Book> findBookByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findBookByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                result.add(book);
            }
        }
        return result;
    }

    public Book findBookByIsbn(String isbn) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
    }
}