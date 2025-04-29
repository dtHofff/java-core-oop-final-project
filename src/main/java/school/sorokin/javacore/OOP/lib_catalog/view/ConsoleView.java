package school.sorokin.javacore.OOP.lib_catalog.view;

import school.sorokin.javacore.OOP.lib_catalog.db.Library;
import school.sorokin.javacore.OOP.lib_catalog.model.Book;
import school.sorokin.javacore.OOP.lib_catalog.model.Magazine;
import school.sorokin.javacore.OOP.lib_catalog.model.Newspaper;

import java.util.Scanner;

public class ConsoleView {

    Library library = new Library();

    public static final int BOOK = 1;
    public static final int MAGAZINE = 2;
    public static final int NEWSPAPER = 3;
    private static final int NEW_PUB_KEY = 1;
    private static final int PUB_LIST_KEY = 2;
    private static final int SEARCH_KEY = 3;
    private static final int PUB_COUNT_KEY = 4;
    private static final int EXIT_KEY = 0;
    public static final String ISBN_WORD = "ISBN";
    public static final String ISSUE_NUM_WORD = "номер выпуска";
    public static final String PUBLICATION_DAY_WORD = "день публикации";
    private static final String TITLE_WORD = "название";
    private static final String AUTHOR_WORD = "автор";
    private static final String YEAR_WORD = "год";
    private static final String WRONG_INT_ALERT = "Вы ввели некорректное число! Попробуйте еще раз";
    private static final String NEGATIVE_INT_ALERT = "Число не может быть меньше нуля! Попробуйте еще раз: ";
    private static final String NOT_INT_ALERT = "Нужно ввести число! Попробуйте еще раз: ";
    private static final String IS_EMPTY_ALERT = "Поле не может быть пустым! Введите значение: ";
    public static final String PUB_TYPE_WORD = String.format("Выберете тип публикации:" +
                    " %d - Book, %d - Magazine, %d - Newspaper",
            BOOK, MAGAZINE, NEWSPAPER);

    private static final String CONSOLE_MENU = String.format("""
                
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
        library.addPublication(new Book(setStringField(TITLE_WORD),
                setStringField(AUTHOR_WORD),
                setStringField(ISBN_WORD),
                setPositiveIntField(YEAR_WORD)));
    }

    private void addNewMagazine() {
        library.addPublication(new Magazine(setStringField(TITLE_WORD),
                setStringField(AUTHOR_WORD),
                setPositiveIntField(YEAR_WORD),
                setPositiveIntField(ISSUE_NUM_WORD)));
    }

    private void addNewNewsPaper(){
        library.addPublication(new Newspaper(setStringField(TITLE_WORD),
                setStringField(AUTHOR_WORD),
                setStringField(PUBLICATION_DAY_WORD),
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

        while (true) {
            switch (setPositiveIntField(PUB_TYPE_WORD)) {
                case BOOK: addNewBook();
                    return;
                case MAGAZINE: addNewMagazine();
                    return;
                case NEWSPAPER: addNewNewsPaper();
                    return;
                default:
                    System.out.println(WRONG_INT_ALERT);
            }
        }
    }

    private void showPubCount(){
        System.out.println("Всего публикаций: " + library.getPublicationCount());
    }

    private void showMenu() {
        while (true) {
            switch (setPositiveIntField(CONSOLE_MENU)) {
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
