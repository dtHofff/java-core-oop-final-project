package school.sorokin.javacore.OOP.lib_catalog.db;

import school.sorokin.javacore.OOP.lib_catalog.model.Publication;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private int publicationCount;

    public Library() {
        publicationCount = 0;
    }

    private final List<Publication> publications = new ArrayList<>();

    public int getPublicationCount() {
        return publicationCount;
    }

    public void addPublication(Publication pub) {
        publications.add(pub);/*добавление публикации в каталог (не забудьте увеличить счетчик
        публикаций в абстрактном классе).*/
        this.publicationCount++;
    }

    public StringBuilder listPublications() {
        StringBuilder pubList = new StringBuilder();
        for (Publication publication : publications) {
            pubList.append(publication.toString())
                   .append("\n");
        }
        return pubList; // вывод всех публикаций (используйте метод toString() ).

    }

    public String searchByAuthor(String author) {
        StringBuilder titlesList = new StringBuilder();
        for (Publication publication: publications) {
            if (publication.getAuthor().toUpperCase().contains(author.toUpperCase())) {
                titlesList.append(publication.getTitle()).append("\n");
            }
        }
        return titlesList.toString();//– поиск и вывод публикаций, где автор совпадает с заданным.
    }

}
