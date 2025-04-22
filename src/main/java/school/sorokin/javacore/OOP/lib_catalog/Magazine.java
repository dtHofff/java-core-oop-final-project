package school.sorokin.javacore.OOP.lib_catalog;

public class Magazine extends Publication {

    private final int issueNumber;

    protected Magazine(String title,
                       String author,
                       int year,
                       int issueNumber) {
        super(title, author, year);
        this.type = "Magazine";
        this.issueNumber = issueNumber;
    }


    @Override
    public String getType() {
        return super.getType();
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

    @Override
    public void printDetails() {

    }

}
