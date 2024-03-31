package com.event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application {
    CirclePane circlePane = new CirclePane(); //
    @Override
    public void start(Stage primary){
        // Pane pane = new Pane(); // StackPane makes the object in the center of scene but Pane can't
        // here, StackPane is better than Pane
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        javafx.scene.control.Button enlarge = new Button("Enlarge");
        //enlarge.setOnAction(new EnlargeHandler());
        enlarge.setOnAction(e -> circlePane.enlarge());

        circlePane.setOnKeyPressed(e ->
        {if(e.getCode() == KeyCode.U){
            circlePane.enlarge();
        }else if(e.getCode() == KeyCode.D){
            circlePane.shrink();
        }
        });

        circlePane.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.PRIMARY){
                circlePane.enlarge();
            }else if(e.getButton() == MouseButton.SECONDARY){
                circlePane.shrink();
            }
        });

        javafx.scene.control.Button shrink = new Button("Shrink");
        shrink.setOnAction(new ShrinkHandler());
        hBox.getChildren().addAll(enlarge, shrink);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);// BorderPane also can carry HBox and StackPane
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);// static method

        Scene scene = new Scene(borderPane);
        primary.setTitle("Control Circle");
        primary.setScene(scene);
        primary.show();
        circlePane.requestFocus();
    }
    class EnlargeHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){circlePane.enlarge();}
    }
    class ShrinkHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            circlePane.shrink();
        }
    }
}
class CirclePane extends StackPane{
    Circle circle = new Circle(50);
    public CirclePane() {
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(3);
        circle.setStyle("-fx-fill: yellow;");
        getChildren().add(circle);
    }
    public void enlarge(){
        circle.setRadius(circle.getRadius() + 2);
    }
    public void shrink(){
        circle.setRadius(circle.getRadius() > 2 ? circle.getRadius() - 2 : circle.getRadius());
    }

}
