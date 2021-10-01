package Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static Scanner sc = new Scanner(System.in);

    public static int genNumber(int min, int max) {
        int number = 0;
        try {
            number = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("輸入有誤");
            return genNumber(min, max);
        }
        if (number < min || number > max) {
            return genNumber(min, max);
        }
        return number;
    }
}
