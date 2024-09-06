package com.example.guessthenumber;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collections;

public class Controller {
    public static final int ROWS = 5;
    public static final int COLS = 6;

    @FXML
    private GridPane numberGrid;

    private int[] numberArray = new int[ROWS * COLS];
    private int[] checkArray = new int[100];

    @FXML
    private Stage resultStage = new Stage();

    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;

    @FXML
    private void initialize() {
        System.out.println("Initialize");
        randomNumberGrid(numberGrid);
        for (int i = 0; i < 100; i++) {
            checkArray[i] = i;
        }
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
                numberArray[index] = number;
                Label numberLabel = new Label(String.valueOf(number));
                numberLabel.getStyleClass().add("label");
                numberLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

                numberGrid.add(numberLabel, col, row);
            }
        }

    }

    @FXML
    private void showResultView() throws Exception {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/guessthenumber/ResultView.fxml"));
            Scene scene = new Scene(loader.load(), 500, 300);
            resultStage.setTitle("I know your number!");
            resultStage.setScene(scene);
    }

    @FXML
    private void handleYesButton() throws Exception {
        System.out.println("You press YES");
        randomNumberGrid(numberGrid);
        for (int i = 0; i < 100; i++) {
            System.out.println(checkArray[i]);     //check
        }
        //resultStage.show();
    }

    @FXML
    private void handleNoButton() throws Exception {
        System.out.println("You press NO");
        randomNumberGrid(numberGrid);
        //resultStage.show();
    }


}
