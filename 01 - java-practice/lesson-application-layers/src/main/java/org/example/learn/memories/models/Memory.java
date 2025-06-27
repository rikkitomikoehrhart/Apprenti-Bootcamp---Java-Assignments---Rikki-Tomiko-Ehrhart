package org.example.learn.memories.models;

public class Memory {
    private int id; // Unique identifier for a memory
    private String from; // The person who shared the memory
    private String content; // The memory itself
    private boolean shareable; // Whether the memory is public or private

    public Memory() {}

    public Memory(int id, String from, String content, boolean shareable) {
        this.id = id;
        this.from = from;
        this.content = content;
        this.shareable = shareable;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }


    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }


    public boolean isShareable() {
        return shareable;
    }
    public void setShareable(boolean shareable) {
        this.shareable = shareable;
    }

    
}
