package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class News implements Serializable {
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

    public LocalDateTime getTime ()  {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    private static final long serialVersionUID = 1L;
    public News(){}
    private int id;
    private String title;
    private String content;
    private LocalDateTime time;
}
