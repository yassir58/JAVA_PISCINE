
/// rename this package to match the directory structure

package day04.ex01.ImagesToChar.src.java.fr._42.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BmpToAscii {
    // ASCII characters from darkest to brightest
    private String ASCII_CHARS;
    private String imagePath;
    private int newWidth;

    public static void main(String[] args) {
        String imagePath = "/Users/yassir/Desktop/it.bmp"; // your BMP file
        int newWidth = 16; // resize width


    }
    public BmpToAscii(String imagePath, int newWidth, String asciiChars) {
        this.imagePath = imagePath;
        this.newWidth = newWidth;
        this.ASCII_CHARS = asciiChars;
    }


    public void execute (){
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            BufferedImage resized = resizeImage(image, newWidth);

            for (int y = 0; y < resized.getHeight(); y++) {
                for (int x = 0; x < resized.getWidth(); x++) {
                    int pixel = resized.getRGB(x, y);
                    Color color = new Color(pixel);

                    int gray = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                    char ascii = mapGrayToChar(gray);
                    System.out.print(ascii);
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Failed to load image: " + e.getMessage());
        }
    }
    // Resizes the image while preserving aspect ratio
    public  BufferedImage resizeImage(BufferedImage original, int newWidth) {
        int width = original.getWidth();
        int height = original.getHeight();
        double aspectRatio = (double) height / width;

        int newHeight = (int) (newWidth * aspectRatio * 0.5); // adjust for font aspect ratio

        BufferedImage resized = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        resized.getGraphics().drawImage(original, 0, 0, newWidth, newHeight, null);
        return resized;
    }

    // Map grayscale value to ASCII character
    public  char mapGrayToChar(int gray) {
        int index = (gray * (ASCII_CHARS.length() - 1)) / 255;
        return ASCII_CHARS.charAt(index);
    }
}
