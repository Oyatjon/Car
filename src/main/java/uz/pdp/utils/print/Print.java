package uz.pdp.utils.print;

import uz.pdp.utils.color.Color;

import static uz.pdp.utils.color.Color.RED;

public class Print {
    public static void println(String str) {
        System.out.println(str);
    }
    public static void println(String color, String str) {
        System.out.println(color + str + Color.RESET);
    }

    public static void print(String str) {
        System.out.print(str);
    }
    public static void print(String color, String str) {
        System.out.println(color + str + Color.RESET);
    }

    public static void warning(String str) {
        println(RED, str);
    }


}
