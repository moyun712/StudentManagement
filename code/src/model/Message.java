package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private int mid;
    private String title;

    public Message(int mid, String title, String content, String name, String time, int count) {
        this.mid = mid;
        this.title = title;
        this.content = content;
        this.name = name;
        this.time = time;
        this.count = count;
    }

    private String content;
    private String name;
    private String time;
    int count;
    private static final long serialVersionUID = 1L;
    public Message(){}

    public Message(String name, String title, String content, String time, int count) {
        this.title = title;
        this.content = content;
        this.name = name;
        this.time = time;
        this.count = count;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
