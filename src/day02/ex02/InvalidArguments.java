package day02.ex02;

public class InvalidArguments extends RuntimeException {
    public InvalidArguments(String message) {
        super(message);
    }
    public InvalidArguments() {
        super("InvalidArguments");
    }
}
