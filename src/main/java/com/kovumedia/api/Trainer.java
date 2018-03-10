package com.kovumedia.api;

import lombok.Data;

@Data
public class Trainer {
    private long id;
    private String name;

    public Trainer(){

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

    public Trainer(long id, String name){
        this.id = id;
        this.name = name;
    }
}
