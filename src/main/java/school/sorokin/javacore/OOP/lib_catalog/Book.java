package school.sorokin.javacore.OOP.lib_catalog;

public class Book extends Publication {

    private final String isbn;

    protected Book(String title, String author, String isbn, int year) {
        super(title, author, year);
        this.type = "Book";
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String getType() {
        return super.getType();
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


    @Override
    public void printDetails() {

    }

}
