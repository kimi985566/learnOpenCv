package com.ycy.learnopencv.Bean;

/**
 * Created by kimi9 on 2018/2/21.
 */

public class OpenCVInfo {

    private long id;
    private String name;
    private String commend;

    public OpenCVInfo(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public OpenCVInfo(long id, String name, String commend) {
        this.id = id;
        this.name = name;
        this.commend = commend;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommend() {
        return commend;
    }

    public void setCommend(String commend) {
        this.commend = commend;
    }
}
