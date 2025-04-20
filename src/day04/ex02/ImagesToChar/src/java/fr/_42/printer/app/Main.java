package day04.ex02.ImagesToChar.src.java.fr._42.printer.app;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;
import day04.ex02.ImagesToChar.src.java.fr._42.printer.logic.BmpToAscii;


public class Main {

    public static class Args {
        @Parameter(names = "--black", description = "Black character")
        private String black;

        @Parameter(names = "--white", description = "White character")
        private String white;


    }
    public static  void main(String[] args) {



        String path = "/Users/yassir/Desktop/CURSUS/JAVA_PISCINE_OBJECT/src/day04/ex01/ImagesToChar/src/resources/it.bmp"; // your BMP file


        JCommander jCommander = new JCommander();
        Args arguments = new Args();
        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);
        String black = arguments.black;
        String white = arguments.white;
        ColoredPrinter cp = new ColoredPrinter.Builder(1, false)
                .foreground(Ansi.FColor.GREEN)
                .background(Ansi.BColor.RED)
                .build();
    BmpToAscii bmpToAscii = new BmpToAscii(path, 50, String.join("", black, white), cp);
    bmpToAscii.execute();

    }
}
