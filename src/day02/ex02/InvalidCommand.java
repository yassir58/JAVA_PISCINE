package day02.ex02;

public class InvalidCommand extends RuntimeException {
    public InvalidCommand(String message) {
        super(message);
    }
    public InvalidCommand() {
        super("InvalidCommand");
    }
}
