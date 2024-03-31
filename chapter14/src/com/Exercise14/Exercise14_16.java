package com.Exercise14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Exercise14_16 extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        Line line1 = new Line(0,0,0,0);
        line1.setStroke(Color.RED);
        Line line2 = new Line(0,0,0,0);
        line2.setStroke(Color.RED);
        Line line3 = new Line(0,0,0,0);
        line3.setStroke(Color.BLUE);
        Line line4 = new Line(0,0,0,0);
        line4.setStroke(Color.BLUE);
        line1.startXProperty().bind(pane.widthProperty().divide(3).multiply(1));
        line2.startXProperty().bind(pane.widthProperty().divide(3).multiply(2));
        line1.endXProperty().bind(pane.widthProperty().divide(3).multiply(1));
        line2.endXProperty().bind(pane.widthProperty().divide(3).multiply(2));
        line1.endYProperty().bind(pane.heightProperty());
        line2.endYProperty().bind(pane.heightProperty());

        line3.startYProperty().bind(pane.heightProperty().divide(3).multiply(1));
        line4.startYProperty().bind(pane.heightProperty().divide(3).multiply(2));
        line3.endYProperty().bind(pane.heightProperty().divide(3).multiply(1));
        line4.endYProperty().bind(pane.heightProperty().divide(3).multiply(2));
        line3.endXProperty().bind(pane.widthProperty());
        line4.endXProperty().bind(pane.widthProperty());
        pane.getChildren().addAll(line1,line2,line3,line4);

        Scene scene = new Scene(pane, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise14_16");
        primaryStage.show();

    }
}
