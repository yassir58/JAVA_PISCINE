
//  how to compile project
javac src/java/fr/_42/printer/*/*.java -d ./target
// how to run project
cd ImagesToChar
java -classpath ./target day04.ex01.ImagesToChar.src.java.fr._42.printer.app.Main "<black>" "<white>"
jar cfm target/images-to-char.jar manifest.txt -C target .
