package day02.ex00;

import javax.xml.transform.Source;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Signature signature = new Signature();

        signature.setFileTypes();
        System.out.println("Enter the file path (or 'exit' to quit):");
        System.out.print("-> ");
        String filePath = scanner.nextLine();
        while (!filePath.equals("exit")) {
            signature.setFilePath(filePath);
            signature.viewFileContent();
            signature.extracFileType();
            System.out.println("PROCESSED");
            signature.setSignature("");
            signature.setFilePath("");
            System.out.print("-> ");
            filePath = scanner.nextLine();
        }

    }
}
