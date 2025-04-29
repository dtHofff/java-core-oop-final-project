package school.sorokin.javacore.OOP.lib_catalog.view;

import school.sorokin.javacore.OOP.lib_catalog.db.Library;
import school.sorokin.javacore.OOP.lib_catalog.model.Book;
import school.sorokin.javacore.OOP.lib_catalog.model.Magazine;
import school.sorokin.javacore.OOP.lib_catalog.model.Newspaper;

import java.util.Scanner;

public class ConsoleView {

    Library library = new Library();

    private static final int NEW_PUB_KEY = 1;
    private static final int PUB_LIST_KEY = 2;
    private static final int SEARCH_KEY = 3;
    private static final int PUB_COUNT_KEY = 4;
    private static final int EXIT_KEY = 0;
    private static final String TITLE_WORD = "название";
    private static final String AUTHOR_WORD = "автор";
    private static final String YEAR_WORD = "год";
    private static final String WRONG_INT_ALERT = "Вы ввели некорректное число! Попробуйте еще раз";
    private static final String NEGATIVE_INT_ALERT = "Число не может быть меньше нуля! Попробуйте еще раз: ";
    private static final String NOT_INT_ALERT = "Нужно ввести число! Попробуйте еще раз: ";
    private static final String IS_EMPTY_ALERT = "Поле не может быть пустым! Введите значение: ";
    private static final String PUB_TYPE_WORD = String.format("""
                
                %d Добавить новую публикацию
                %d Вывести список всех публикаций
                %d Поиск публикации по автору
                %d Общее количество публикаций
                %d Выход
                
                """, NEW_PUB_KEY, PUB_LIST_KEY, SEARCH_KEY, PUB_COUNT_KEY, EXIT_KEY);

    private String setStringField(final String request) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%S: ", request);
        String res = scanner.nextLine();
        while (res.trim().isEmpty()) {
            System.out.println(IS_EMPTY_ALERT);
            res = scanner.nextLine();
        }
        return res;
    }

    private int returnInt(){
        Scanner scanner = new Scanner(System.in);
        int num = -1;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
            isNegative(num);
        } else {
            System.out.println(NOT_INT_ALERT);
        }
        return num;
    }

    private void isNegative(final int num){
        if (num < 0) {
            System.out.println(NEGATIVE_INT_ALERT);
        }
    }

    private int setPositiveIntField(final String request) {
        System.out.printf("%S: ", request);
        int num;
        do {
            num = returnInt();
        } while (num < 0);
        return num;
    }

    private void addNewBook() {
        final String isbnWord = "ISBN";
        library.addPublication(new Book(setStringField(TITLE_WORD),
                setStringField(AUTHOR_WORD),
                setStringField(isbnWord),
                setPositiveIntField(YEAR_WORD)));
    }

    private void addNewMagazine() {
        final String issueNumWord = "номер выпуска";
        library.addPublication(new Magazine(setStringField(TITLE_WORD),
                setStringField(AUTHOR_WORD),
                setPositiveIntField(YEAR_WORD),
                setPositiveIntField(issueNumWord)));
    }

    private void addNewNewsPaper(){
        final String publicationDayWord = "день публикации";
        library.addPublication(new Newspaper(setStringField(TITLE_WORD),
                setStringField(AUTHOR_WORD),
                setStringField(publicationDayWord),
                setPositiveIntField(YEAR_WORD)));
    }

    private void showPublications(){
        System.out.println(library.listPublications());
    }

    private void showSearchByAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите искомого автора: ");
        final String result = library.searchByAuthor(scanner.next());
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
            switch (setPositiveIntField(pubTypeWord)) {
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
        System.out.println("Всего публикаций: " + library.getPublicationCount());
    }

    private void showMenu() {
        while (true) {
            switch (setPositiveIntField(PUB_TYPE_WORD)) {
                case NEW_PUB_KEY: choseAndAddPub();
                return;
                case PUB_LIST_KEY: showPublications();
                return;
                case SEARCH_KEY: showSearchByAuthor();
                return;
                case PUB_COUNT_KEY: showPubCount();
                return;
                case EXIT_KEY: System.exit(0);
                default:
                    System.out.println(WRONG_INT_ALERT);
            }
        }
    }

    public void start(){
        while(true) showMenu();
    }

}
