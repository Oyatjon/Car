package uz.pdp.utils.input;

import java.util.Scanner;

import static uz.pdp.utils.print.Print.print;
import static uz.pdp.utils.print.Print.println;

public class Input {
    private static final Scanner SCANNER_NUM = new Scanner(System.in);
    private static final Scanner SCANNER_STR = new Scanner(System.in);
    public static String getStr(String str) {
        print(str);
        return SCANNER_STR.next();
    }

    public static String getStr(String color, String str) {
        print(color, str);
        return  SCANNER_STR.next();
    }

    public static Integer getNum(String str) {
        print(str);
        return SCANNER_NUM.nextInt();
    }
    public static Integer getNum(String color, String str) {
        print(color, str);
        return SCANNER_NUM.nextInt();
    }
}
