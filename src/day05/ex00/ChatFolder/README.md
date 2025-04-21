javac -cp "lib/postgresql-42.7.5.jar" \
-d target/day05/ex00/ChatFolder \
src/main/java/fr/chat/*.java
java -cp 'lib/postgresql-42.7.5.jar:target/day05/ex00/ChatFolder/src/main/java/fr/chat/' ./src/main/java/fr/chat/Main.java
