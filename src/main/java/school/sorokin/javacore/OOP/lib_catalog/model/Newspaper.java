package school.sorokin.javacore.OOP.lib_catalog.model;

public class Newspaper extends Publication {

    private final String publicationDay;

    public Newspaper(String title,
                     String author,
                     String publicationDay,
                     int year) {
        super(title, author, year);
        this.type = "Newspaper";
        this.publicationDay = publicationDay;
    }

    public String getPublicationDay() {
        return publicationDay;
    }

    @Override
    public String toString() {
        return String.format("%s{title:'%s', author:'%s', year:'%d', publication day:'%s'}",
                getType(),
                getTitle(),
                getAuthor(),
                getYear(),
                getPublicationDay());
    }


    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void printDetails() {

    }

}
