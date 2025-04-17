package day02.ex02;

public class FolderDoesNotExist extends RuntimeException {
    public FolderDoesNotExist(String message) {
        super(message);
    }
    public FolderDoesNotExist() {
        super("FolderDoesNotExist");
    }
}
