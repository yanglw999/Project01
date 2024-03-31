package com.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ShowBorderPane extends Application {
    @Override
    public void start(Stage primary){
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new CustomPane("Top"));
        borderPane.setCenter(new CustomPane("Center"));
        borderPane.setBottom(new CustomPane("Bottom"));
        borderPane.setLeft(new CustomPane("Left"));
        borderPane.setRight(new CustomPane("Right"));
        //
        Scene scene = new Scene(borderPane);
        primary.setScene(scene);
        primary.setTitle("Show BorderPane");
        primary.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
//
class CustomPane extends StackPane{
    public CustomPane(String title){ // constructor
        getChildren().add(new Label(title));
        setStyle("-fx-border-color: Red;");
        setPadding(new Insets(11.5,12.5,13.5,14.5));

    }
}