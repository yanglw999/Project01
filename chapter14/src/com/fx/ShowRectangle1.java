package com.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ShowRectangle1 extends Application {
    @Override
    public void start(Stage primaryStage){
        Scene scene = new Scene(new RectanglePane());
        primaryStage.setTitle("Rectangle in Pane");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
class RectanglePane extends Pane{
    public RectanglePane(){
        Rectangle rectangle = new Rectangle(50,50,50,50);
        rectangle.widthProperty().bind(widthProperty().divide(2));
        rectangle.heightProperty().bind(heightProperty().divide(2));
        rectangle.setStrokeWidth(10);
        rectangle.setStyle("-fx-border-color: RED");
        rectangle.setFill(Color.color(0.5,0.3,0.7));
        getChildren().add(rectangle);
    }
}
