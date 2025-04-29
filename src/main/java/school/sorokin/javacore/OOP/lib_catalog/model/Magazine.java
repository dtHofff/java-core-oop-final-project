package school.sorokin.javacore.OOP.lib_catalog.model;

public class Magazine extends Publication {

    private final int issueNumber;

    public Magazine(String title,
                    String author,
                    int year,
                    int issueNumber) {
        super(title, author, year);
        this.type = "Magazine";
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public String toString() {
        return String.format("%s{title:'%s', author:'%s', year:'%d', issue number:'%d'}",
                getType(),
                getTitle(),
                getAuthor(),
                getYear(),
                getIssueNumber());
    }
}
