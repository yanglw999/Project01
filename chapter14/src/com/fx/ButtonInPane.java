package com.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonInPane extends Application {
    public void start(Stage primaryStage){
        Button b1 = new Button("Start");
        StackPane sp1= new StackPane();// stage-> scene -> pane(getChildren().add())
        sp1.getChildren().add(b1);
        Scene sc1 = new Scene(sp1,200,100);
        primaryStage.setTitle("Button in Pane");
        primaryStage.setScene(sc1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
