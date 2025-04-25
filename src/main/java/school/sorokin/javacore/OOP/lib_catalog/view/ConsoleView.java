package school.sorokin.javacore.OOP.lib_catalog.view;

import school.sorokin.javacore.OOP.lib_catalog.db.Library;
import school.sorokin.javacore.OOP.lib_catalog.model.Book;
import school.sorokin.javacore.OOP.lib_catalog.model.Magazine;
import school.sorokin.javacore.OOP.lib_catalog.model.Newspaper;
import school.sorokin.javacore.OOP.lib_catalog.model.Publication;

import java.util.Scanner;

public class ConsoleView implements IView {

    private final String titleWord = "название";
    private final String authorWord = "автор";
    private final String yearWord = "год";

    protected void addNewBook() {
        final String isbnWord = "ISBN";
        Library.addPublication(new Book(setStringField(titleWord),
                setStringField(authorWord),
                setStringField(isbnWord),
                setIntField(yearWord)));
    }

    private void addNewMagazine() {
        final String issueNumWord = "номер выпуска";
        Library.addPublication(new Magazine(setStringField(titleWord),
                setStringField(authorWord),
                setIntField(yearWord),
                setIntField(issueNumWord)));
    }

    private void addNewNewsPaper(){
        final String publicationDayWord = "день публикации";
        Library.addPublication(new Newspaper(setStringField(titleWord),
                setStringField(authorWord),
                setStringField(publicationDayWord),
                setIntField(yearWord)));
    }

    private void showPublications(){
        System.out.println(Library.listPublications());
    }

    private void showSearchByAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите искомого автора: ");
        final StringBuilder result = Library.searchByAuthor(scanner.next());
        if (result.isEmpty()) {
            System.out.println("Не найдено!");
        } else {
            System.out.println(result);
        }

    }

    private void choseAndAddPub(){
        final int book = 1;
        final int magazine = 2;
        final int newspaper = 3;

        final String pubTypeWord = String.format("Выберете тип публикации:" +
                        " %d - Book, %d - Magazine, %d - Newspaper",
                book, magazine, newspaper);
        final String wrongIntAlert = "Вы ввели некорректное число! Попробуйте еще раз";

        while (true) {
            switch (setIntField(pubTypeWord)) {
                case book: addNewBook();
                    return;
                case magazine: addNewMagazine();
                    return;
                case newspaper: addNewNewsPaper();
                    return;
                default:
                    System.out.println(wrongIntAlert);
            }
        }
    }

    private void showPubCount(){
        System.out.println("Всего публикаций: " + Publication.getPublicationCount());
    }

    private void showMenu() {

        final int newPubKey = 1;
        final int pubListKey = 2;
        final int searchKey = 3;
        final int pubCountKey = 4;
        final int exitKey = 0;

        final String pubTypeWord = String.format("""
                
                %d Добавить новую публикацию
                %d Вывести список всех публикаций
                %d Поиск публикации по автору
                %d Общее количество публикаций
                %d Выход
                
                """, newPubKey, pubListKey, searchKey, pubCountKey, exitKey);
        final String wrongIntAlert = "Вы ввели некорректное число! Попробуйте еще раз";

        while (true) {
            switch (setIntField(pubTypeWord)) {
                case newPubKey: choseAndAddPub();
                return;
                case pubListKey: showPublications();
                return;
                case searchKey: showSearchByAuthor();
                return;
                case pubCountKey: showPubCount();
                return;
                case exitKey: System.exit(0);
                default:
                    System.out.println(wrongIntAlert);
            }
        }
    }

    public void start(){
        while(true) showMenu();
    }

}
