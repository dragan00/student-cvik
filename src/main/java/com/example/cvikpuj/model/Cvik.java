package com.example.cvikpuj.model;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cvik extends Table{
    @Entity(type="INTEGER", size=32, primary = true)
    int id;

    @Entity(type="INTEGER", size=32)
    int student_id;

    @Entity(type="INTEGER", size=32)
    int classroom_id;

    @Entity(type="VARCHAR")
    String entry_timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_id() throws Exception {
        Student st = (Student) Student.get(Student.class, this.student_id);
        return st.getName();
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getClassroom_id() throws Exception {
        Classroom c = (Classroom) Classroom.get(Classroom.class, this.classroom_id);
        return c.getName();
    }

    public void setClassroom_id(int classroom_id) {
        this.classroom_id = classroom_id;
    }

    public String getEntry_timestamp(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date date = new Date(Long.parseLong(this.entry_timestamp));
        return formatter.format(date);
    }
    public void setEntry_timestamp(){
        Date date = new Date();
        long timeMilli = date.getTime();
        this.entry_timestamp = String.valueOf(timeMilli);
    }
}
