
//  how to compile project
javac -cp "lib/*" src/java/fr/_42/printer/*/*.java -d ./target
// how to run project
cd ImagesToChar
java -cp "lib/*:target" day04.ex02.ImagesToChar.src.java.fr._42.printer.app.Main --black "0" --white "."
jar cfm target/images-to-char.jar manifest.txt -C target .
