package Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static Scanner sc;

    public static int genNumber(int min, int max) {
        sc = new Scanner(System.in);
        int number = 0;
        try {
            number = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("輸入有誤");
            return genNumber(min, max);
        }
        if (number < min || number > max) {
            System.out.println("輸入有誤");
            return genNumber(min, max);
        }
        return number;
    }

    public static int buyAmount() {
        return genNumber(0, Global.BUYING_MAX_AMOUNT);
    }

    public static String namingWord() {
        sc = new Scanner(System.in);
        String name = sc.nextLine();
        if (name.length() > Global.NAME_LIMIT) {
            System.out.println("不可以超過8個字喔!");
            return namingWord();
        }
        int leftNumber = Global.NAME_LIMIT - name.length();
        for (int i = 0; i < leftNumber; i++) {
            name += " ";
        }
        return name;
    }
}
