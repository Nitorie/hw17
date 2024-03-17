public enum EnumBooksLib {
    Book1("Title1", "Author1", 2022, "ISBN1"),
    Book2("Title2", "Author2", 2010, "ISBN2"),
    Book3("Title3", "Author3", 2019, "ISBN3"),
    Book4("Title4", "Author4", 2021, "ISBN4");

    private final String title;
    private final String author;
    private final int year;
    private final String isbn;

    EnumBooksLib(String title, String author, int year, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }
}