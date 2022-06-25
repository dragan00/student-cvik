package com.example.cvikpuj.controller;

import com.example.cvikpuj.Main;
import com.example.cvikpuj.model.Cvik;
import com.example.cvikpuj.model.Student;
import com.example.cvikpuj.model.Table;
import com.example.cvikpuj.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CvikController implements Initializable {

    @FXML
    TextField card;

    @FXML
    private Label errorMsg;

    @FXML
    Button backBtn;

    @FXML
    TableView cvikListTbl;

    @FXML
    TableColumn studentNameCol;

    @FXML
    TableColumn classroomNameCol;

    @FXML
    TableColumn entryTimestampCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (this.studentNameCol != null) {
            this.studentNameCol.setCellValueFactory(new PropertyValueFactory<>("student_id"));
            this.classroomNameCol.setCellValueFactory(new PropertyValueFactory<>("classroom_id"));
            this.entryTimestampCol.setCellValueFactory(new PropertyValueFactory<>("entry_timestamp"));
            this.fillCvikList();
        }
    }

    private void fillCvikList() {
        try {
            System.out.println("Pocetak...");
            List<?> cvikList = Table.list(Cvik.class);
            System.out.println("Nastavak...");
            ObservableList<?> cvikListObservableList = FXCollections.observableList(cvikList);
            this.cvikListTbl.setItems(cvikListObservableList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void addEntry(int student_id, int classroom_id) throws Exception {
        Cvik c = new Cvik();
        c.setStudent_id(student_id);
        c.setClassroom_id(classroom_id);
        c.setEntry_timestamp();
        try {
            c.save();
            this.errorMsg.setText("Uspjesna prijava.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void onEnter(ActionEvent ae) throws Exception {
        System.out.println("Enter");
        try {
            Student st = (Student) Student.get_by_card(this.card.getText().toString());
            addEntry(st.getId(), 1);
        } catch (Exception e) {
            this.errorMsg.setText("Nepostojeci korisnik.");
        }

        this.card.setText("");

    }

    @FXML
    protected void goToLogin(){
        try {
            Main.showWindow(
                    "login.fxml",
                    "Prijava u sustav", 600, 215);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    protected void goBack(){
        try {
            Main.showWindow(
                    "menu.fxml",
                    "Dobrodošli", 600, 215);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}