package museum.string_practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringPractice practice = new StringPractice();
        System.out.println("Введите пару строк: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println("После конкатенации разных типов: "
                + practice.concatDiffTypes(string, List.of(1, 4, 7)));
        System.out.println("После конкатенации разных типов: "
                + practice.concatDiffTypes(string, List.of(1.5, 4.8, 7.1)));
        System.out.println("Введите один символ-разделитель для функции split() ");
        String delimiter = scanner.next();
        String[] strings = practice.strSplitUse(string, delimiter);
        System.out.println("После использования split(): " + Arrays.toString(strings));
        System.out.println("После использования StringBuilder(): " + practice.strBuilderUse(strings, "#"));
    }
}
