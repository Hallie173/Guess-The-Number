package com.example.guessthenumber;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultViewController {

    @FXML
    private Label numberResult;

    public void setResult(int result) {
        numberResult.setText(String.valueOf(result));
    }
}
