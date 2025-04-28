package school.sorokin.javacore.OOP.lib_catalog.model;

import java.util.Objects;

public abstract class Publication implements Printable {

    protected String type;
    private String title;
    private String author;
    private int year;


    protected Publication(String title, String author, int year) {
           this.title = title;
           this.year = year;
           this.author = author;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return getYear() == that.getYear() && Objects.equals(getType(),
                that.getType()) && Objects.equals(getTitle(),
                that.getTitle()) && Objects.equals(getAuthor(),
                that.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getTitle(), getAuthor(), getYear());
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
