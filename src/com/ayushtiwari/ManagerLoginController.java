package com.ayushtiwari;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManagerLoginController {

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton logIn;

    public void initialize() {

        RequiredFieldValidator validator = new RequiredFieldValidator();
        userName.getValidators().add(validator);
        validator.setMessage("Required");

        userName.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    userName.validate();
                }
            }
        });
        RequiredFieldValidator validator2 = new RequiredFieldValidator();
        password.getValidators().add(validator2);
        validator2.setMessage("Required");

        password.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    password.validate();
                }
            }
        });


    }

    @FXML
    public void onLogin(ActionEvent event) throws Exception {
        String managerUserName = userName.getText();
        String managerPassword = password.getText();


        if (managerUserName.trim().isEmpty() || managerPassword.trim().isEmpty()) {
            //No Action
            System.out.println("Invalid Inputs");
        } else {
            /*
            Check if Password is correct
            */

            Parent dashboard = FXMLLoader.load(getClass().getResource("managerDashboard.fxml"));
            Scene dashboardScene = new Scene(dashboard);
            Stage windowDashboard = new Stage();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.getOwner().hide();
            windowDashboard.setScene(dashboardScene);
            windowDashboard.setFullScreen(true);
            windowDashboard.show();

        }

    }
}