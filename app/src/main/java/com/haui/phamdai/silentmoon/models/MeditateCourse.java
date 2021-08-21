package com.haui.phamdai.silentmoon.models;

// MeditateCourse - MeditateTopic : many-to-one
public class MeditateCourse {
    private int id;
    // link
    private int meditateTopicId;
    private int image;
    private String name;

    public MeditateCourse(int id, int image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }

    public MeditateCourse(int id, int meditateTopicId, int image, String name) {
        this.id = id;
        this.meditateTopicId = meditateTopicId;
        this.image = image;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMeditateTopicId() {
        return meditateTopicId;
    }

    public void setMeditateTopicId(int meditateTopicId) {
        this.meditateTopicId = meditateTopicId;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
