package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Reply implements Serializable {
    private static final long serialVersionUID = 1L;
    private int mid;
    private String content;

    public Reply() {}

    private String name;
    private LocalDateTime time;
    private int rid;


    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }


}
