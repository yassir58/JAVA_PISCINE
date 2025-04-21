package day05.ex00.ChatFolder.src.main.java.fr.chat;

import java.util.UUID;

public class Message {

    private UUID id;
    private User author;
    private ChatRoom chatRoom;
    private String content;
    private long timestamp;

    public Message(User author, ChatRoom chatRoom, String content) {
        this.id = UUID.randomUUID();
        this.author = author;
        this.chatRoom = chatRoom;
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }

    public UUID getId() {
        return id;
    }
    public User getAuthor() {
        return author;
    }
    public ChatRoom getChatRoom() {
        return chatRoom;
    }
    public String getContent() {
        return content;
    }
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", author=" + author +
                ", chatRoom=" + chatRoom +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        if (timestamp != message.timestamp) return false;
        if (!id.equals(message.id)) return false;
        if (!author.equals(message.author)) return false;
        if (!chatRoom.equals(message.chatRoom)) return false;
        return content.equals(message.content);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + chatRoom.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }
}
