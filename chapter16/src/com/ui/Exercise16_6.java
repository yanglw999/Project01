package com.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise16_6 extends Application {
    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));

        TextField textField = new TextField();
        textField.setPrefColumnCount(80);
        Label label0 = new Label("input info: ", textField);
        label0.setContentDisplay(ContentDisplay.RIGHT);
        HBox hBox0 = new HBox(5);
        hBox0.setAlignment(Pos.CENTER);
        hBox0.getChildren().add(label0);

        RadioButton left = new RadioButton("Left");
        RadioButton center = new RadioButton("Center");
        RadioButton right = new RadioButton("Right");
        ToggleGroup toggleGroup = new ToggleGroup();
        left.setToggleGroup(toggleGroup);
        center.setToggleGroup(toggleGroup);
        right.setToggleGroup(toggleGroup);
        TextField tF2 = new TextField();
        Label label = new Label("Column Size", tF2);
        label.setContentDisplay(ContentDisplay.RIGHT);

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(left,center,right,label);

        borderPane.setTop(hBox0);
        borderPane.setBottom(hBox);
        left.setOnAction( e ->{
            textField.setAlignment(Pos.BOTTOM_LEFT);
        });
        center.setOnAction( e ->{
            textField.setAlignment(Pos.CENTER);
        });
        right.setOnAction( e ->{
            textField.setAlignment(Pos.BOTTOM_RIGHT);
        });
        tF2.setOnAction( e ->{
            textField.setPrefColumnCount(Integer.parseInt(tF2.getText()));
        });

        Scene scene = new Scene(borderPane,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_6");
        primaryStage.show();
    }
}
