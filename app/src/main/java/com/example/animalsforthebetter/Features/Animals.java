package com.example.animalsforthebetter.Features;

public class Animals {
    private long id;
    private String name;
    private String type;
    private long duration;

    public Animals(int id, String name, String type, long duration) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.duration = duration;
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

    public long getDuration() {return duration; }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
