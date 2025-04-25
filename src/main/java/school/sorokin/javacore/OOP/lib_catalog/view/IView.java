package school.sorokin.javacore.OOP.lib_catalog.view;

import java.util.Scanner;

public interface IView {

    String notIntAlert = "Нужно ввести число! Попробуйте еще раз";

    default String setStringField(final String request) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%S: ", request);
        return scanner.nextLine();
    }

    default int setIntField(final String request) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%S: ", request);
        while (!scanner.hasNextInt()) {
            System.out.println(notIntAlert);
            scanner = new Scanner(System.in);
        }
        return scanner.nextInt();
    }

}
