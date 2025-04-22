package school.sorokin.javacore.OOP.lib_catalog;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        library.addPublication(new Book("BookTitle", "Author", "65468465", 546531));
        library.addPublication(new Magazine("MAXIM","publisher", 2025, 66546846 ));
        library.addPublication(new Newspaper("Times", "NYT", "Friday", 2023));
        System.out.println(Publication.getPublicationCount());
        System.out.println(library.listPublications());


    }

}
