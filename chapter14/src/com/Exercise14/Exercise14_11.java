package com.Exercise14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise14_11 extends Application {
    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(5));
        SmileFacePane smileFacePane = new SmileFacePane();
        borderPane.setCenter(smileFacePane);

        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        Text text = new Text("big smile");
        text.setFont(Font.font("Carrier", FontWeight.BOLD, FontPosture.ITALIC,30));
        text.setFill(Color.RED);
        hBox.getChildren().add(text);
        borderPane.setTop(hBox);

        Scene scene = new Scene(borderPane,800,800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise14_11");
        primaryStage.show();
    }
}
