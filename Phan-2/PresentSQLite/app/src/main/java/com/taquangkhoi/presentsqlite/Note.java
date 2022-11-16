package com.taquangkhoi.presentsqlite;

public class Note {
    int id;
    String title;
    String content;

    // Dùng khi làm việc với Cursor
    public Note(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // Dùng khi mình tạo Note, do ID sẽ tự tăng nên không cần truyền vào
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
