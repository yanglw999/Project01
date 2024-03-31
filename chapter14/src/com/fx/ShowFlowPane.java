package com.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ShowFlowPane extends Application {
    @Override
    public void start(Stage primary){
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(11,12,13,14));
        flowPane.setHgap(5);
        flowPane.setVgap(5);
        TextField textField = new TextField();// purpose is to set the prefColumnCount
        textField.setPrefColumnCount(1);
        flowPane.getChildren().addAll(new Label("First Name:"), new TextField(), new Label("MI:"));
        flowPane.getChildren().addAll(textField, new Label("Last Name:"), new TextField());
        //
        Scene scene = new Scene(flowPane, 200,250);
        primary.setScene(scene);
        primary.setTitle("Show FlowPane");
        primary.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
