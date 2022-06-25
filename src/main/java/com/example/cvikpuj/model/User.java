package com.example.cvikpuj.model;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class User {
    @Entity(type="INTEGER", size=32, primary = true)
    int id;

    @Entity(type="VARCHAR", size=256)
    String name;

    @Entity(type="VARCHAR", size=256)
    String email;

    @Entity(type="VARCHAR", size=256)
    String password;

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

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static Object get_by_email(String email, String password) throws Exception {
        String SQL = "SELECT * FROM User WHERE email = '" + email + "' AND password = '" + password + "'";
        Statement stmt = Database.CONNECTION.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        if (rs.next()){
            Object obj = new User();
            Class<?> otherCls = obj.getClass();
            for (Field f : otherCls.getDeclaredFields()){
                f.set(obj, rs.getObject(f.getName()));
            }
            return obj;
        } else {
            throw new Exception("Ne postoji korisnik");
        }
    }
}
