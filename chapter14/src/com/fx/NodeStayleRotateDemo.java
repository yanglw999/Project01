package com.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class NodeStayleRotateDemo extends Application {
    @Override
    public void start(Stage primary){
        Button button = new Button("OK");
        button.setStyle("-fx-border-color: blue;");
        //
        StackPane pane = new StackPane();
        pane.setStyle("-fx-border-color: BLACK; -fx-background-color: lightgray;");
        pane.setRotate(45);
        pane.getChildren().add(button);
        //
        Scene scene = new Scene(pane, 200,150);
        primary.setTitle("Stayle & Rotate Demo");
        primary.setScene(scene);
        primary.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
