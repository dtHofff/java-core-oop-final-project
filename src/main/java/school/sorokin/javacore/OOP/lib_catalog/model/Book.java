package school.sorokin.javacore.OOP.lib_catalog.model;

public class Book extends Publication {

    private final String isbn;

    public Book(String title, String author, String isbn, int year) {
        super(title, author, year);
        this.type = "Book";
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return String.format("%s{title:'%s', author:'%s', year:'%d', ISBN:'%s'}",
                getType(),
                getTitle(),
                getAuthor(),
                getYear(),
                getIsbn());
    }
}
