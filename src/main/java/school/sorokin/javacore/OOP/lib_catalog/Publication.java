package school.sorokin.javacore.OOP.lib_catalog;

public abstract class Publication implements Printable {

    protected String type;
    private String title;
    private String author;
    private int year;
    private static int publicationCount = 0;

    protected Publication(String title, String author, int year) {
           this.title = title;
           this.year = year;
           this.author = author;
    }

    public static int getPublicationCount() {
        return publicationCount;
    }

    public static void increasePublicationCount() {
        Publication.publicationCount++;
    }

    public String getType() {
        return type;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
