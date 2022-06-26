package com.example.cvikpuj.model;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student extends Table{
    @Entity(type="INTEGER", size=32, primary = true)
    int id;

    @Entity(type="VARCHAR", size=100)
    String name;

    @Entity(type="VARCHAR", size=100)
    String card;

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

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }


    public static Object get_by_card(String card) throws Exception {
        String SQL = "SELECT * FROM Student WHERE card = '" + card + "'";
        Statement stmt = Database.CONNECTION.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        if (rs.next()){
            Object obj = new Student();
            Class<?> otherCls = obj.getClass();
            for (Field f : otherCls.getDeclaredFields()){
                f.set(obj, rs.getObject(f.getName()));
            }
            System.out.println("Uspjesno prijavljen student.");
            return obj;
        } else {
            throw new Exception("Ne postoji student");
        }
    }
}
