package com.example.guessthenumber;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultController {

    @FXML
    private Label numberResult;

    @FXML
    private void initialize() {
    }

    public void setNumber(int number) {
        if (numberResult != null) {
            numberResult.setText(String.valueOf(number));
        } else {
            System.err.println("numberResult is null. Make sure FXML is correctly loaded.");
        }
    }
}
