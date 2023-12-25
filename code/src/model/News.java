package model;

import java.io.Serializable;
import java.sql.Time;

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

    public String getTime ()  {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    private static final long serialVersionUID = 1L;
    public News(){}
    private int id;

    public News(int id, String title, String content, String time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
    }

    private String title;
    private String content;
    private String time;
}
