package day01.ex02;

public class UsersArrayList implements UsersList{

    private User[] users;
    private int userCount;
    private static final int INITIAL_CAPACITY = 10;

    public UsersArrayList() {
        users = new User[INITIAL_CAPACITY];
        userCount = 0;
    }

    @Override
    public void addUser(User user) {
        if (userCount == users.length) {
            resize();
        }
        users[userCount++] = user;
    }

    @Override
    public User getUserById(int id) throws UserNotFoundException {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getId() == id) {
                return users[i];
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getUserByIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= userCount) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return users[index];
    }

    @Override
    public int getUserCount() {
        return userCount;
    }

    private void resize() {
        int newSize = (users.length) * 2;
        User[] newUsers = new User[newSize];
        System.arraycopy(users, 0, newUsers, 0, users.length);
        users = newUsers;
    }
}
