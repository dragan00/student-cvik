package com.example.cvikpuj.controller;

import com.example.cvikpuj.Main;
import com.example.cvikpuj.model.Student;
import com.example.cvikpuj.model.Table;
import com.example.cvikpuj.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MenuController implements Initializable {


    @FXML
    Button collegesBtn;

    @FXML
    Button studentsBtn;

    @FXML
    Button cvikListBtn;

    @FXML
    Button cvikBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    protected void openStudents() throws IOException {
            Main.showWindow(
                    "student.fxml",
                    "Administracija studenata", 600, 215);

        }

    @FXML
    protected void openColleges() throws IOException {
        Main.showWindow(
                "college.fxml",
                "Administracija fakulteta", 600, 215);

    }

    @FXML
    protected void openCvikList() throws IOException {
        Main.showWindow(
                "cvik-list.fxml",
                "Cvik Lista", 700, 215);

    }

    @FXML
    protected void openCvik() throws IOException {
        Main.showWindow(
                "cvik.fxml",
                "Cvik Lista", 600, 215);

    }

}