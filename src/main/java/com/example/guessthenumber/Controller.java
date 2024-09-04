package com.example.guessthenumber;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.util.Collections;

public class Controller {
    public static final int ROWS = 5;
    public static final int COLS = 6;

    @FXML
    private GridPane numberGrid;

    @FXML
    private void initialize() {
        System.out.println("Initialize");
        randomNumberGrid(numberGrid);
    }

    private void randomNumberGrid(GridPane numberGrid) {
        numberGrid.getChildren().clear();

        ObservableList<Integer> numbers = FXCollections.observableArrayList();
        for (int i = 0; i < ROWS*COLS; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        numberGrid.getColumnConstraints().clear();
        numberGrid.getRowConstraints().clear();

        for (int col = 0; col < COLS; col++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setHalignment(HPos.CENTER);
            colConstraints.setFillWidth(true);
            colConstraints.setHgrow(Priority.ALWAYS);
            numberGrid.getColumnConstraints().add(colConstraints);
        }

        for (int row = 0; row < ROWS; row++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setValignment(VPos.CENTER);
            rowConstraints.setFillHeight(true);
            rowConstraints.setVgrow(Priority.ALWAYS);
            numberGrid.getRowConstraints().add(rowConstraints);
        }

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                int index = row * COLS + col;
                int number = numbers.get(index);

                Label numberLabel = new Label(String.valueOf(number));
                numberLabel.getStyleClass().add("label");
                numberLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

                numberGrid.add(numberLabel, col, row);
            }
        }
    }
    @FXML
    private void handleYesButton() {

    }
    @FXML
    private void handleNoButton() {

    }
}
