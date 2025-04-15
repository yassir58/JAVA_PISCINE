package day01.ex03;

public class UserIdsGenerator {

    static int state  = 0;
    private int userId = 0;

    public void generateUserId() {
        userId = state;
        state++;
    }

    public int generateId() {
        generateUserId();
        return userId;
    }
    static UserIdsGenerator getInstance() {
        return new UserIdsGenerator();
    }
}
