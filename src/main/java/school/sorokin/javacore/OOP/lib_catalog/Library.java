package school.sorokin.javacore.OOP.lib_catalog;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private static List<Publication> publications = new ArrayList<>();

    public void addPublication(Publication pub) {
        publications.add(pub);/*добавление публикации в каталог (не забудьте увеличить счетчик
        публикаций в абстрактном классе).*/
        Publication.increasePublicationCount();
    }

    public StringBuilder listPublications() {
        StringBuilder pubList = new StringBuilder();
        for (Publication publication : publications) {
            pubList.append(publication.toString())
                   .append("\n");
        }
        return pubList; // вывод всех публикаций (используйте метод toString() ).

    }

    public void searchByAuthor(String author) { //– поиск и вывод публикаций, где автор совпадает с заданным.

    }

}
