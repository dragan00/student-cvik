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

public class CollegeController implements Initializable {

    @FXML
    TextField collegeNameTxt;

    @FXML
    TableView collegeTbl;

    @FXML
    TableColumn collegeIDCol;

    @FXML
    TableColumn collegeNameCol;

    @FXML
    TableColumn collegeCardCol;

    @FXML
    Button addCollegeBtn;

    @FXML
    Button backBtn;


    College selectedCollege = null;

    @FXML
    protected void addCollege() {
        String name = this.collegeNameTxt.getText();

        if (name.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Molimo unesite naziv fakulteta!", ButtonType.OK);
            alert.setTitle("Upozorenje");
            alert.setHeaderText("Greška s unosom podataka");
            alert.showAndWait();
        } else if (this.selectedCollege == null) {
            College c = new College();
            c.setName(name);
            try {
                c.save();
                this.collegeNameTxt.setText("");
                this.fillColleges();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            this.selectedCollege.setName(name);
            try {
                this.selectedCollege.update();
                this.removeSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.collegeIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.collegeNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.fillColleges();
    }

    private void fillColleges() {
        try {
            List<?> collegesList = Table.list(College.class);
            ObservableList<?> studentsObservableList = FXCollections.observableList(collegesList);
            this.collegeTbl.setItems(studentsObservableList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void deleteCollege(){
        if (selectedCollege != null){
            try {
                selectedCollege.delete();
                this.fillColleges();
                this.removeSelection();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @FXML
    protected void selectCollege(){
        this.selectedCollege = (College) this.collegeTbl.getSelectionModel().getSelectedItem();
        if (selectedCollege != null) {
            this.addCollegeBtn.setText("Uredi fakultet");
            this.collegeNameTxt.setText(this.selectedCollege.getName());
        }else{
            this.addCollegeBtn.setText("Dodaj fakultet");
        }
    }

    @FXML
    protected void removeSelection() {
        this.selectedCollege = null;
        this.fillColleges();
        this.addCollegeBtn.setText("Dodaj fakultet");
        this.collegeNameCol.setText("");
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