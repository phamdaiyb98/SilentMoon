package com.haui.phamdai.silentmoon.models;

// home topic
public class Topic {
    private int id;
    private int backgroundImg;
    private String topic;

    public Topic(int backgroundImg, String topic) {
        this.backgroundImg = backgroundImg;
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(int backgroundImg) {
        this.backgroundImg = backgroundImg;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}
