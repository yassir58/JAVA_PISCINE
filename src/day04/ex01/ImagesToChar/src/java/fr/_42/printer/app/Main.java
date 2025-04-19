package day04.ex01.ImagesToChar.src.java.fr._42.printer.app;

import day04.ex01.ImagesToChar.src.java.fr._42.printer.logic.BmpToAscii;
public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Invalid arguments. make sure to provide 3 arguments: --black=<black> --white=<white> --path=<path>");
            return;
        }

        if (args[0].isEmpty()) {
            System.out.println("Invalid argument. Usage: black is empty");
            return;
        }
        if (args[1].isEmpty()) {
            System.out.println("Invalid argument. Usage: white is empty");
            return;
        }

        String black = args[0];
        String white = args[1];
        String path = "/Users/yassir/Desktop/CURSUS/JAVA_PISCINE_OBJECT/src/day04/ex01/ImagesToChar/src/resources/it.bmp"; // your BMP file

        BmpToAscii bmpToAscii = new BmpToAscii(path, 50, String.join("", black, white));
        bmpToAscii.execute();

    }
}
