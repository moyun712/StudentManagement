package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Reply implements Serializable {
    private static final long serialVersionUID = 1L;

    public Reply(int mid, String content, String name,String time, int rid) {
        this.mid = mid;
        this.content = content;
        this.name = name;
        this.time = time;
        this.rid = rid;
    }

    private int mid;
    private String content;



    private String name;
    private String time;
    private int rid;


    public Reply() {}

    public Reply(String content, String name, String time, int mid) {
        this.content=content;
        this.name = name;
        this.time = time;
        this.mid = mid;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }


}
