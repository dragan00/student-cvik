package com.example.cvikpuj.model;

public class College extends Table{
    @Entity(type="INTEGER", size=32, primary = true)
    int id;

    @Entity(type="VARCHAR", size=100)
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
