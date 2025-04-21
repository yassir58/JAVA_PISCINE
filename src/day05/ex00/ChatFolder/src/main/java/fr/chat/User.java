package day05.ex00.ChatFolder.src.main.java.fr.chat;

import java.sql.Connection;
import java.util.UUID;

public class User {
    private UUID id;
    private String email;
    private String password;
    private String login;
    private ChatRoom[] chatRooms;
    private ChatRoom[] joinedChatRooms;

    public User(String email, String password, String login) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.password = password;
        this.login = login;
        this.chatRooms = new ChatRoom[0];
        this.joinedChatRooms = new ChatRoom[0];
    }
    public UUID getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getLogin() {
        return login;
    }
    public ChatRoom[] getChatRooms() {
        return chatRooms;
    }
    public ChatRoom[] getJoinedChatRooms() {
        return joinedChatRooms;
    }

    public void createChatRoom(ChatRoom chatRoom, Connection conn) {
        ChatRoom[] newChatRooms = new ChatRoom[chatRooms.length + 1];
        System.arraycopy(chatRooms, 0, newChatRooms, 0, chatRooms.length);
        newChatRooms[chatRooms.length] = chatRoom;
        this.chatRooms = newChatRooms;

    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!email.equals(user.email)) return false;
        if (!password.equals(user.password)) return false;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + login.hashCode();
        return result;
    }

}
