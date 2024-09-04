package com.example.guessthenumber;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Collections;

public class Main extends Application {
    public static final int ROWS = 5;
    public static final int COLS = 6;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("NumberView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/guessthenumber/NumberView.fxml"));
//        primaryStage.setTitle("Guess the Number");
//
//        VBox root = new VBox();
//        Pane choicePane = new Pane();
//        Pane numberPane = new Pane();
//        GridPane numberGrid = new GridPane();
//        randomNumberGrid(numberGrid);
//
//        Button yesButton = new Button("Yes");
//        Button noButton = new Button("No");
//        Label statusLabel = new Label("Is your number in the grid?");
//
//        yesButton.setOnAction(e -> handleYesButton());
//        noButton.setOnAction(e -> handleNoButton());
//
//        choicePane.getChildren().addAll(yesButton, noButton);
//        numberPane.getChildren().add(numberGrid);
//        root.getChildren().addAll(statusLabel, numberGrid, choicePane);
//        Scene scene = new Scene(root);
//
//        scene.getStylesheets().add(getClass().getResource("/com/example/guessthenumber/styles.css").toExternalForm());
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }
//    public void start(Stage primaryStage) throws Exception {
//        // Load FXML từ file
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/guessthenumber/NumberView.fxml"));
//        VBox root = loader.load();  // Lấy root từ FXML
//
//        primaryStage.setTitle("Guess the Number");
//
//        // Tạo các phần tử UI khác
//        Pane choicePane = new Pane();
//        Pane numberPane = new Pane();
//        GridPane numberGrid = new GridPane();
//        randomNumberGrid(numberGrid);
//
//        Button yesButton = new Button("Yes");
//        Button noButton = new Button("No");
//        Label statusLabel = new Label("Is your number in the grid?");
//
//        yesButton.setOnAction(e -> handleYesButton());
//        noButton.setOnAction(e -> handleNoButton());
//
//        choicePane.getChildren().addAll(yesButton, noButton);
//        numberPane.getChildren().add(numberGrid);
//
//        // Thêm các phần tử vào root từ FXML
//        root.getChildren().addAll(statusLabel, numberGrid, choicePane);
//
//        // Tạo scene và thêm CSS
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("/com/example/guessthenumber/styles.css").toExternalForm());
//
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }


    private void randomNumberGrid(GridPane numberGrid) {
        numberGrid.getChildren().clear();

        ObservableList<Integer> numbers = FXCollections.observableArrayList();
        for (int i = 0; i < ROWS*COLS; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                int index = row * COLS + col;
                int number = numbers.get(index);
                Label numberLabel = new Label(String.valueOf(number));
                numberLabel.setPrefSize(100, 72);

                numberGrid.add(numberLabel, col, row);
            }
        }
    }

    private void handleYesButton() {

    }

    private void handleNoButton() {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
