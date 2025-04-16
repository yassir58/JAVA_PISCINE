package day02.ex00;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class Signature {

    private String filePath;
    private String fileType;
    private String signature;
    private Map<String, String> fileTypes;


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getSignature() {
        return signature;
    }

    public Signature (){
        this.filePath = "";
        this.fileType = "";
        this.signature = "";
        this.fileTypes = new java.util.HashMap<>();
    }

    public void viewFileContent() {
        try (FileInputStream input = new FileInputStream(filePath)) {
            int data = 0;
            // read only 8 bytes in Hexadecimal
            while (signature.length() < 255) {
                data = input.read();
                if (data == -1) {
                    break;
                }
                // convert to hexadecimal it would be in the form of 0x00
                String hex = String.format("%02X ", data);
                signature += hex;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
    public void setFileTypes (){
        try(FileInputStream input = new FileInputStream("/Users/yassir/Desktop/CURSUS/JAVA_PISCINE_OBJECT/src/day02/ex00/signatures.txt")) {
            int data = 0;
            while (true){
                String line = "";
                data = 0;
                while (data != '\n'){
                    data = input.read();
                    if (data == -1) {
                        break;
                    }
                    line += String.format("%c", data);
                }
                if (data == -1) {
                    break;
                }
                String[] parts = line.split(", ");
                if (parts.length != 2) {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }
                if (parts[0].isEmpty() || parts[1].isEmpty()) {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }

                if (parts[0] != null && parts[1] != null) {
                    // remove the new line character from the second part
                    parts[1] = parts[1].replaceAll("\n", "");
                    fileTypes.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String extracFileType () {
        String fileType = "";
        for (Map.Entry<String, String> entry : fileTypes.entrySet()) {
                if (signature.contains(entry.getValue())) {
                    fileType = entry.getKey();
                    // print the file type with new line in result.txt
                    try (FileOutputStream output = new FileOutputStream("/Users/yassir/Desktop/CURSUS/JAVA_PISCINE_OBJECT/src/day02/ex00/result.txt", true)) {
                        // append the file type to the result.txt
                        output.write((fileType + "\n").getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }

        }
            return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

}
