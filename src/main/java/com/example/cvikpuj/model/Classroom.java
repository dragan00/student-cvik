package com.example.cvikpuj.model;

public class Classroom extends Table{
    @Entity(type="INTEGER", size=32, primary = true)
    int id;

    @Entity(type="VARCHAR", size=100)
    String name;

    @Entity(type="INTEGER", size=100)
    int college_id;

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

    public int getCollege_id() {
        return college_id;
    }

    public void setCollege_id(int college_id) {
        this.college_id = college_id;
    }
}
