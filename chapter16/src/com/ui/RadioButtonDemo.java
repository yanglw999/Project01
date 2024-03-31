package com.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RadioButtonDemo extends CheckBoxDemo {
    @Override
    protected BorderPane getPane(){
        BorderPane pane = super.getPane();

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton rbRed = new RadioButton("Red");
        rbRed.setTextFill(Color.RED);
        rbRed.setToggleGroup(toggleGroup);
        RadioButton rbGreen = new RadioButton("Green");
        rbGreen.setTextFill(Color.GREEN);
        rbGreen.setToggleGroup(toggleGroup);
        RadioButton rbBlue = new RadioButton("Blue");
        rbBlue.setTextFill(Color.BLUE);
        rbBlue.setToggleGroup(toggleGroup);

        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(5,5,5,5));
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(rbRed,rbBlue,rbGreen);
        vBox.setStyle("-fx-border-color: RED;-fx-stroke-width: 4");

        pane.setLeft(vBox);

        EventHandler<ActionEvent> eventEventHandler = e->{
            if(rbRed.isSelected()){
                text.setFill(Color.RED);
            }else if(rbBlue.isSelected()){
                text.setFill(Color.BLUE);
            }else if(rbGreen.isSelected()){
                text.setFill(Color.GREEN);
            }else {
                text.setFill(Color.BLACK);
            }
        };
        rbRed.setOnAction(eventEventHandler);
        rbBlue.setOnAction(eventEventHandler);
        rbGreen.setOnAction(eventEventHandler);

        return pane;
    }
}
