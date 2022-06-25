package com.example.cvikpuj.controller;

import com.example.cvikpuj.Main;
import com.example.cvikpuj.model.College;
import com.example.cvikpuj.model.Student;
import com.example.cvikpuj.model.Table;
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

public class StudentController implements Initializable {

    @FXML
    TextField studentNameTxt;

    @FXML
    TextField studentCardTxt;

    @FXML
    TableView studentTbl;

    @FXML
    TableColumn studentIDCol;

    @FXML
    TableColumn studentNameCol;

    @FXML
    TableColumn studentCardCol;

    @FXML
    Button addStudentBtn;

    @FXML
    Button backBtn;

    Student selectedStudent = null;

    @FXML
    protected void addStudent() {
        String name = this.studentNameTxt.getText();
        String card = this.studentCardTxt.getText();

        if (name.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Molimo unesite naziv studenta!", ButtonType.OK);
            alert.setTitle("Upozorenje");
            alert.setHeaderText("Greška s unosom podataka");
            alert.showAndWait();
        } else if (this.selectedStudent == null) {
            Student s = new Student();
            s.setName(name);
            s.setCard(card);
            try {
                s.save();
                this.studentNameTxt.setText("");
                this.studentCardTxt.setText("");
                this.fillStudents();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            this.selectedStudent.setName(name);
            this.selectedStudent.setCard(card);
            try {
                this.selectedStudent.update();
                this.removeSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.studentIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.studentNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.studentCardCol.setCellValueFactory(new PropertyValueFactory<>("card"));
        this.fillStudents();
    }

    private void fillStudents() {
        try {
            List<?> studentsList = Table.list(Student.class);
            ObservableList<?> studentsObservableList = FXCollections.observableList(studentsList);
            this.studentTbl.setItems(studentsObservableList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void deleteStudent(){
        if (selectedStudent != null){
            try {
                selectedStudent.delete();
                this.fillStudents();
                this.removeSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @FXML
    protected void selectStudent(){
        this.selectedStudent = (Student) this.studentTbl.getSelectionModel().getSelectedItem();
        this.addStudentBtn.setText("Uredi studenta");
        this.studentNameTxt.setText(this.selectedStudent.getName());
        this.studentCardTxt.setText(this.selectedStudent.getCard());
    }

    @FXML
    protected void removeSelection() {
        this.selectedStudent = null;
        this.fillStudents();
        this.addStudentBtn.setText("Dodaj Studenta");
        this.studentNameTxt.setText("");
        this.studentCardTxt.setText("");
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