package day05.ex00.ChatFolder.src.main.java.fr.chat;

import java.util.UUID;

public class ChatRoom {
    private UUID id ;
    private String name;
    User owner;
    Message[] messages;

    public ChatRoom(String name, User owner) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.owner = owner;
        this.messages = new Message[0];
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public Message[] getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        Message[] newMessages = new Message[messages.length + 1];
        System.arraycopy(messages, 0, newMessages, 0, messages.length);
        newMessages[messages.length] = message;
        this.messages = newMessages;
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", messages=" + messages.length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatRoom)) return false;

        ChatRoom chatRoom = (ChatRoom) o;

        if (!id.equals(chatRoom.id)) return false;
        if (!name.equals(chatRoom.name)) return false;
        if (!owner.equals(chatRoom.owner)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return messages.length == chatRoom.messages.length;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + owner.hashCode();
        result = 31 * result + messages.length;
        return result;
    }
}
