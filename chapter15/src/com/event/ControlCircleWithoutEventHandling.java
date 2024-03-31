package com.event;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircleWithoutEventHandling extends Application {
    @Override
    public void start(Stage primary){
       // Pane pane = new Pane(); // StackPane makes the object in the center of scene but Pane can't
        StackPane pane = new StackPane();// here, StackPane is better than Pane
        Circle circle = new Circle(50);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(3);
        circle.setStyle("-fx-fill: yellow;");
        pane.getChildren().add(circle);

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        javafx.scene.control.Button enlarge = new Button("Enlarge");
        javafx.scene.control.Button shrink = new Button("Shrink");
        hBox.getChildren().addAll(enlarge, shrink);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);// BorderPane also can carry HBox and StackPane
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        Scene scene = new Scene(borderPane);
        primary.setTitle("Control Circle without EventHandling");
        primary.setScene(scene);
        primary.show();
    }
}
