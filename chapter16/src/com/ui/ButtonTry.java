package com.ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonTry extends Application {
    @Override
    public void start(Stage primary){
        Text text = new Text(300,300,"JavaFX Programming");
        Pane pane = new Pane();
        pane.getChildren().add(text);

        javafx.scene.control.Button btLeft = new Button("Left");
        javafx.scene.control.Button btRight = new javafx.scene.control.Button("Right");

        HBox hBox = new HBox(60);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btLeft,btRight);

        btLeft.setOnMouseClicked(e -> {text.setX(text.getX() - 5);});
        btRight.setOnMouseClicked(e -> text.setX(text.getX() + 5));

        BorderPane borderPane = new BorderPane();
       // borderPane.setCenter(text);
        borderPane.setCenter(pane);// text->pane->borderPane
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane);
        primary.setTitle("ButtonTry");
        primary.setScene(scene);
        primary.show();
        text.requestFocus();
    }
}
