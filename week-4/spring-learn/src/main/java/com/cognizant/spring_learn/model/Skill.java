package com.cognizant.spring_learn.model;

public class Skill {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill [name=" + name + "]";
    }
}
